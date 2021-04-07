package com.hehe.base.http.okhttp;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 解析Reqeus
 *  请求头 的 请求行
 *  请求域名
 *  端口号
 *  url 后面的资源 file
 */
public class SocketRequestServer {

    private final String K = " ";
    private final String VIERSION = "HTTP/1.1";
    private final String GRGN = "\r\n";

    /**
     * todo 通过Request对象，寻找到域名HOST
     * @param request
     * @return
     */
    public String getHost(Request request) {
        try {
            // http://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=13cb58f5884f974987abbead9c658f
            URL url = new URL(request.getUrl());
            return url.getHost(); // restapi.amap.com
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * todo 端口
     * @param request
     * @return
     */
    public int getPort(Request request) {
        try {
            URL url = new URL(request.getUrl());
            int port = url.getPort();
            return port == -1 ? url.getDefaultPort() : port;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * todo 获取请求头的所有信息
     * @param request
     * @return
     */
    public String getRequestHeaderAll(Request request) {
        // 得到请求方式
        URL url = null;
        try {
            url = new URL(request.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String file = url.getFile();

        // TODO 拼接 请求头 的 请求行  GET /v3/weather/weatherInfo?city=110101&key=13cb58f5884f974987abbead9c658f HTTP/1.1\r\n
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(request.getRequestMethod()) // GET or POST
        .append(K)
        .append(file)
        .append(K)
        .append(VIERSION)
        .append(GRGN);

        // TODO 获取请求集 进行拼接
        /**
         * Content-Length: 48\r\n
         * Host: restapi.amap.com\r\n
         * Content-Type: application/x-www-form-urlencoded\r\n
         */
        if (!request.getmHeaderList().isEmpty()) {
            Map<String,String> mapList = request.getmHeaderList();
            for (Map.Entry<String, String> entry: mapList.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append(":").append(K)
                        .append(entry.getValue())
                        .append(GRGN);
            }
            // 拼接空行，代表下面的POST，请求体了
            stringBuffer.append(GRGN);
        }

        // TODO POST请求才有 请求体的拼接
        if ("POST".equalsIgnoreCase(request.getRequestMethod())) {
            stringBuffer.append(request.getRequestBody().getBody()).append(GRGN);
        }

        return stringBuffer.toString();
    }

    /**
     * 获得urlString HTTP or HTTPS
     * @param urlString
     * @return
     */
    public String queryHttpOrHttps(String urlString) {
        try {
            URL url = new URL(urlString);

            return url.getProtocol();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
