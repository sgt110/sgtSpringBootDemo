package com.sgt;

import cn.hutool.http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONString;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * @author �����
 * @description TODO
 * @date 2023/12/15 14:18
 */
public class HttpsTest {

    public static void main(String[] args) throws Exception {
        RequestConfig globalConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)         // ���ӳػ�ȡ���ӳ�ʱ
                .setConnectTimeout(1000)                   // ���ӽ�����ʱ
                .setSocketTimeout(5000)                    // �ȴ���Ӧ��ʱ
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .build();
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) {
            }
            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) {
            }
        }};
        // ����SSL�����ģ�����֤����֤
        SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
        sslcontext.init(null, trustAllCerts, new java.security.SecureRandom());
        SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE);

        // ���� CloseableHttpClient ����
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(ssf).setDefaultRequestConfig(globalConfig)
                .build();

        // ���� HttpGet ���󣬲���������URL
        HttpGet httpGet = new HttpGet("https://apigateway.yonyoucloud.com/open-auth/dataCenter/getGatewayAddress?tenantId=b9wuchko?");

        // �������󣬻�ȡ��Ӧ
        HttpResponse response = httpClient.execute(httpGet);

        // ��ȡ��Ӧʵ��
        HttpEntity entity = response.getEntity();

        // ��ȡ��Ӧ����
        String responseBody = EntityUtils.toString(entity);

        // �����Ӧ
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        System.out.println("Response Body: " + responseBody);

        // �ر�httpClient
        httpClient.close();

    }


    @Test
    public void testHttpGet(){
        String str = HttpUtil.get("https://apigateway.yonyoucloud.com/open-auth/dataCenter/getGatewayAddress?tenantId=b9wuchko");
        System.out.println(str);
    }
    @Test
    public void test2(){
        JSONString jsonString = new JSONString() {
            @Override
            public String toJSONString() {
                return null;
            }
        };
    }
    @Test
    public void test3() {
        String str = "endnum,endmoney,def5,def4,def3,def2,assetnum,assetname,opennum,openmoney,bn_zjnum,bn_zjmoneey,tx_zjnum,tx_zjmoney,bn_jsnum,bn_jsmoney";
        String[] strArr = str.split(",");
        for (String s : strArr) {
            System.out.print("\"" + s + "\",");
        }
    }
    @Test
    public void test4() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT                                                                                              \n");
        sql.append("  BVO.PK_PURCHASEB AS B_PK,                                                                         \n");
        sql.append("  HVO.PK_PURCHASEH AS hpk,                                                                         \n");
        sql.append("  ORG.CODE         AS dealerCode,                                                                   \n");
        sql.append("  SU.USER_CODE     AS sheetCreatedBy,                                                               \n");
        sql.append("  BVO.DEF10        AS productCode,                                                                  \n");
        sql.append("  BVO.DEF11        AS ownedCarType,                                                                 \n");
        sql.append("  BVO.DEF12        AS vehiclePurpose,                                                               \n");
        sql.append("  BVO.DEF13        AS vehiclePurpose2,                                                              \n");
        sql.append("  BVO.PURCHASEONE  AS vehiclePrice,                                                                  \n");
        // add baibsh 20231124 ���������ֶ������������������ڲ�����
        sql.append("  HVO.applycate  AS applycate                                                                  \n");
        // end baibsh 20231124 ���������ֶ������������������ڲ�����
        sql.append("FROM                                                                                                \n");
        sql.append("  YTJT_YS_ASSETPURCHASEBVO BVO                                                                      \n");
        sql.append("  JOIN YTJT_YS_ASSETPURCHASEHVO HVO ON BVO.PK_PURCHASEH = HVO.PK_PURCHASEH                     \n");
        sql.append("  LEFT JOIN ORG_ORGS ORG ON ORG.PK_ORG = HVO.PK_ORG                                                 \n");
        sql.append("  LEFT JOIN SM_USER SU ON SU.CUSERID = HVO.CREATOR                                                  \n");
        sql.append("WHERE                                                                                               \n");
        sql.append("  BVO.PK_PURCHASEH = ?                                                                              \n");
        System.out.println(sql.toString());
    }
}
