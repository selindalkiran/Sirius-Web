package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by olcayekin on 16/06/2017.
 */
public class Configuration {
    private static Configuration instance;

    private Properties configProps = new Properties();
    protected static final Logger log = Logger.getLogger(Configuration.class);

    private String buildNumber;
    private int waitTime;
    private int implicitlyWait;
    private String browserName;
    private String browserVersion;
    private String platform;
    private String excelName;
    private String dbConnInfo;
    private String baseUrl;

    private Configuration() {
        InputStream is = null;
        try {
            is = ClassLoader.getSystemResourceAsStream("config.properties");
            configProps.load(is);
            String jenkinsBuildId = System.getenv("BUILD_ID");
            this.buildNumber = jenkinsBuildId != null ? jenkinsBuildId : configProps.getProperty("build.number");
            this.waitTime = Integer.parseInt(configProps.getProperty("wait.Time"));
            this.implicitlyWait = Integer.parseInt(configProps.getProperty("implicitly.Wait"));
            this.browserName = configProps.getProperty("browser.name");
            this.browserVersion = configProps.getProperty("browser.version");
            this.platform = configProps.getProperty("platform");
            this.excelName = configProps.getProperty("excelName");
            this.dbConnInfo = configProps.getProperty("db.conn.info");

            this.baseUrl = configProps.getProperty("base.url");

        } catch (Exception e) {
            log.error(e);
        } finally {

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error(e);
                }
            }
        }
    }

    public static Configuration getInstance() {

        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {

        if (instance == null) {

            instance = new Configuration();
        }
    }

    public String[][] stringTo2DArray(String string) {
        String splitter = "\\|\\|";
        String[][] datas = new String[(string.split(splitter)).length][(string.split(splitter)[0]).split(",").length];

        for (int i = 0; i < (string.split(splitter)).length; i++) {
            datas[i] = (string.split(splitter)[i]).split(",");
        }
        return datas;
    }

    public Platform selectPlatform( String platform) {
        Platform plat = null;
        switch (platform) {
            case "WINDOWS":
            case "WIN":
            case "Win":
                plat = Platform.WINDOWS;
                break;

            case "MAC":
            case "MAC OS":
            case "Mac":
                plat = Platform.MAC;
                break;

            case "LINUX":
                plat = Platform.LINUX;
                break;
            default:
                break;
        }
        return plat;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public String getDbConnInfo() {
        return dbConnInfo;
    }

    public String getServerUrl() {
        return baseUrl;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getImplicitlyWait() {
        return implicitlyWait;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public Platform getPlatform() {
        return selectPlatform(platform);
    }

    public String getExcelName() {
        return excelName;
    }
    // public String[][] getUserNamePasswordDatas()
    // return stringTo2DArray(userName)

}
