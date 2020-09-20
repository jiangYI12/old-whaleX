package com.whalex.pay.order.util;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.whalex.pay.api.entity.PayTest;
import lombok.SneakyThrows;


/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/29 21:10
 */
public  class AliPayUtil {

    //https://opendocs.alipay.com/apis/api_1/alipay.trade.cancel 支付宝操作作用文档
    //https://opendocs.alipay.com/open/00y8k9 支付宝 JDK 文档
    //https://github.com/alipay/alipay-easysdk/blob/master/APIDoc.md 支付宝JDK参数详细文档
    //https://opendocs.alipay.com/open/54/cyz7do 支付宝demo 与 jdk 下载地址

    @SneakyThrows
    public static String  downloadBill(PayTest payTest){
        Factory.setOptions(getOptions());
        //trade指商户基于支付宝交易收单的业务账单；signcustomer是指基于商户支付宝余额收入及支出等资金变动的帐务账单
        //日账单格式为yyyy-MM-dd，最早可下载2016年1月1日开始的日账单；月账单格式为yyyy-MM，最早可下载2016年1月开始的月账单
        AlipayDataDataserviceBillDownloadurlQueryResponse alipayDataDataserviceBillDownloadurlQueryResponse
                = Factory.Payment.Common().downloadBill(payTest.getBillType(),
                payTest.getStartTime().substring(0,7));
        return alipayDataDataserviceBillDownloadurlQueryResponse.billDownloadUrl;
    }

    //交易退款查询
    @SneakyThrows
    public static AlipayTradeFastpayRefundQueryResponse queryRefund(PayTest payTest){
        //outTradeNo 交易创建时传入的商户订单号
        //outRequestNo 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
        AlipayTradeFastpayRefundQueryResponse alipayTradeFastpayRefundQueryResponse =
                Factory.Payment.Common().queryRefund(payTest.getOrderNo(),payTest.getOrderNo());
        return alipayTradeFastpayRefundQueryResponse;
    }

    public static AlipayTradeRefundResponse refund(PayTest payTest) throws Exception {
        Factory.setOptions(getOptions());
        AlipayTradeRefundResponse response = Factory.Payment.Common().refund(payTest.getOrderNo(), String.valueOf(payTest.getTotalAmount()));
        // 3. 处理响应或异常
        if (ResponseChecker.success(response)) {
            System.out.println("调用成功");
            return response;
        } else {
            System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            return response;
        }
    }

    public static String createPage(PayTest payTest) throws Exception {
        Factory.setOptions(getOptions());
        AlipayTradePagePayResponse response =  Factory.Payment.Page()
                .pay(payTest.getProductName(), payTest.getOrderNo(),String.valueOf(payTest.getTotalAmount()),"https://www.json.cn/");
        return response.body;
    }

    public static String createOrder(PayTest payTest){
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(getOptions());
        try {

            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    .preCreate(payTest.getProductName(), payTest.getOrderNo(), String.valueOf(payTest.getTotalAmount()));
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功");
                return response.qrCode;
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
                return response.msg;
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";

        //<-- 请填写您的AppId，例如：2019091767145019 -->
        config.appId = "2016092900624669";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中 <-- 请填写您的应用私钥，例如：MIIEvQIBADANB ... ... -->
        config.merchantPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAQb4CRh+VrSjdCjzNX9/Cwi4hJxt8eCw0WGXKsz4igxG63Sny8mY3rSOPOZJpfQRU2/yAPYp8z8ARTrw8cuSeT3pOjiYkBWllZ+vo9Zfnr2PAKZfLfy9/e2pgA7NHIfH16K2lGI5GFJAgnKxMBh65Yn27cJuHjNqmYPk3E54LBffjjMM4z22Lke5PhG/cmMBaT0J41XPbJwbcwYgK94xsLEisnvrQJzaLsQ5zJGdifn38OUddI7+j80xrb7KsJSoY/TeZpL5VZrvNOvnwxTfWpZtWl2txzjOcGcyExQN+rtkauK17E6oo9tbPDCp022xB3t4hFH2z0VT3x6149K41AgMBAAECggEAZNBIRI1OIl678hMr+9rSjcoIbHLK/imPxY1+ZbhCrOoNs65IXPkAM99aRihg1543G2TXsw2sn7LFLFWRTIqa/X1HjBvcCxBd6iGno7P4NVr9s3x+HqzYbwJZeSMvdkhOYpcEdvM4UgmzyI6eOBvPZrTuU7mN5xxmecVb31kCL3LYyMW1iB35mLvG88WAcxVMDtzuVkwlMknnotN1QKIAdp8tvBDQFSdqAoVKrRRpjbD2T/IsSPAJp06J7pYLOFr5eAiICa0gDvc4LEF2skjAH6Ew7CmWF/2/+Q7yUwsbBUU3PTdqhFZQniOKvQ9GH1HuepiYSlZ7ZKYPzuZT31MnOQKBgQDrpZGePoFVaN0ASNvHCsQ4gkIea1J6plQvc5igxALOc2TrzIWcptHWZAffgIW+ogQY3Y+T5p6RmFxFZrLLhK/6psitU+wb5G6RiiSWnGRGBUxWE0j8jC7VoTGMIUxM75YUxZXX84A0y3o6qI4EzE5687G86bOPYgnFmfjIJfppBwKBgQCLVadEb4neftrRqYcYHTqjg3H8gle7Lz4I0GvIan3nyEIUE1yqE3hYZx1+fPIsgNsP6Gc6QDOlnYEOU/tmj47wMu7qsKPDjDxcdPQVaKMgbhS33QLdh9QaluBIkYWfpclSVF4VAvH75dmEC5FdBBQ2yWAXv+1mmymG5MKHHRfL4wKBgAcbyoXEivBBppEQoZiiiYLO4yG5yRYsGFQKH6uR3ifOMVgvpkQwgBoAkIA8h0xV5Nu/K0qh5VytBPOPAovDJ+/ewiUAaBn7TR6U1T+53giCtmfOUyBTNkJ5h14bzwpvG87qmveVv+NX1Asa9JXOd/ubiFwTjLghk/vjBi87fg9XAoGAMO052DEmg4eeBQN3mcMhxSsyCo4mimdTbDrrriue3JYYhf4qitpdZwWGeNUdIP16bwKXxP+oYx6Eo+hfnisI8VWhSa4PQ2pqA7lZwG7G4WtmQQ4NpIa+tzuFtFXNSzsnD47qnowzNtYGZHS/bZ8yDe72nEBb96zCj0ii+lj/8ysCgYAstPaIuG5fv7lhfkopgfgnAURaX0t2UYOCvLC+GyLJ4kz5/MDiFVS0wqIRGHDvSVHrWo6BYsqYIkvpV2WvAWjTJxpPsX0OaFmOWz83R6TpyqSli+NePQlUwsJ0l8fIIgLZ5PLAPtLMfwYZ13GZ2JzlS959Ik4gwm0Mm0gK4NtFKA==";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
        //<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->
//        config.merchantCertPath = "";
        //<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->
//        config.alipayCertPath = "";
        //<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->
//        config.alipayRootCertPath = "";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可 <-- 请填写您的支付宝公钥，例如：MIIBIjANBg... -->
         config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiyvsR8zzrrpmqFaMH+d1mB/cUrlD4vGb8gFScNPapZhjKpim8aFww3zyFKqtrC3Ge8LZbAoJ0oj4amEh1r3YgptG1D9XSFegAxWhEEDzT1YhgpTfoFE+ZN1p/iAB0FTdmKTuFSDC2FUmrgfRq4WD0Cu5hV0X8pH9EtI+SUORrU9vx0kKV9rvZI4dZi4MwVSTfG8G0Ek55FIc6+1HLlY5rimVaKzkkHoBKejpWy6vLT374GCOyeXMurFLEmcoNiA+WrH7hmzm4BSrH823kvB7d8zik0FoFtYxbTm2D8g8FhWLaLUDMk57a+VzRcRYR2ihd4u33jeX45TvhpJN/++pKwIDAQAB";

        //可设置异步通知接收服务地址（可选） <-- 请填写您的支付类接口异步通知接收服务地址，例如：https://www.test.com/callback -->
        config.notifyUrl = "http://b9ggb8.natappfree.cc/whale-pay/payOrder/callBack";

        //可设置AES密钥，调用AES加解密相关接口时需要（可选） <-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->
        config.encryptKey = "gJigCrdddRvJIZo+tid2Qw==";

        return config;
    }
}
