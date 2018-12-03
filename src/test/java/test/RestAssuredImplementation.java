package test;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by olcayekin on 04/07/2017.
 */
public class RestAssuredImplementation {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    String addOperation;

    @Step("Call add operator")
    public void callAddOperator() {
        addOperation = "http://www.dneonline.com/calculator.asmx?op=Add";
    }


    @Step("I add some numbers <table>")
    public void getNumberFromTable( Table table ) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        int number1 = 0;
        int number2 = 0;
        for (TableRow row : rows) {
            number1 = Integer.parseInt(row.getCell(columnNames.get(0)));
            number2 = Integer.parseInt(row.getCell(columnNames.get(1)));
        }


        HashMap headermap = new HashMap<>();
        headermap.put("Content-Type", "text/xml; charset=utf-8");
        String reqBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soap:Body>" +
                "<Add xmlns=\"http://tempuri.org/\">" +
                "<intA>" + number1 + "</intA>" +
                " <intB>" + number2 + "</intB>" +
                " </Add>" +
                "</soap:Body>" +
                "</soap:Envelope>";

        response = given().headers(headermap).body(reqBody).
                post(addOperation);

    }

    @Step("Expected true result <table>")
    public void expectedResult( Table table ) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            response.then().body("Envelope.Body.AddResponse.AddResult", equalTo(row.getCell(columnNames.get(0))));
            response.body().xmlPath().get("Envelope.Body.AddResponse.AddResult");

        }

    }
}
