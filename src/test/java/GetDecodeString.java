import org.testng.annotations.Test;

import static gdprCrypt.Decoder.*;
import static gdprCrypt.EncodeVendors.*;
import static gdprCrypt.PurposeData.*;
import static gdprCrypt.VendorData.*;
import static gdprCrypt.Encoder.consent;

public class GetDecodeString {

    public static String decodedStr = "BOOR44gOOR44gAAABBRUBH-AAAF3BAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

    //204
    @Test
    public void withoutPurposes(){
        consent();
    }

    //200OK
    @Test
    public void withAllPurposes(){
        consent(allPurposes);
    }

/*    204
      если Information storage and access = true оставляем personal data fields в Bid Request без изменений, записываем
     в логи
       Если CPM то без personalization мы можем ответить рекламой.
       Например если есть только black list или нет аудитории в кампании и на экаунте вообще
        не отвечаем рекламой в кампаниях CPI/CPC поскольку для оптимизации нам нужны все три consent.
        */
    @Test
    public void withpurp13only(){
        consent(purp13only);
    }


    /*

    если Information storage and access = true оставляем personal data fields в Bid Request без изменений, записываем в логи
           не отвечаем рекламой в кампаниях CPI/CPC поскольку для оптимизации нам нужны все три consent.
       если Ad selection, delivery, reporting = false
       не показываем рекламу, отвечаем 204 No Bid
       а если Personalisation = true
   можем использовать таргетинг по Audience, и
   передаем IDFA для получения списка тегов для прогонки по Optimization Model
*/
    @Test
    public void withPurp12only(){
        consent(purp12only);
    }


    /*        если Information storage and access = false
        очищаем Personal data fields в Bid Request перед записью в логи - RTBC-1603
        на использование этих же полей в показе рекламы данное значение не влияет
        не отвечаем рекламой в кампаниях CPI/CPC
        поскольку для оптимизации нам нужны все три consent.
     а если Personalisation = true
можем использовать таргетинг по Audience, и
передаем IDFA для получения списка тегов для прогонки по Optimization Model
если Information storage and access = false - то по CPM мы отвечаем рекламой,
        но не записываем персональные данные. Impression, click записываем
     */
    @Test
    public void withpurp23only(){
        consent(purp23only);
    }

/*     204 нафиг не надо, эквивалентно novalid
    @Test
    public void withnoAllowedPurposes(){
        consent(noAllowedPurposes);
    }*/

    // noErrors, 200
    @Test
    public void withdublicatedPurposes12(){
        consent(dublicatedPurposes12);
    }

    //204
    @Test
    public void withnoValid(){
        consent(noValid);
    }

    //204
    @Test
    public void withOneVendor(){
        consentVendors0(vendorIds, 6000);
    }

    //204
    @Test
    public void withoneMaxVendor(){
        consentVendors1(isRange, 77);
    }

    @Test
    public static void testException(){

        System.out.println(decodeUrlbased(decodedStr));
    }

    @Test
    public static void testdecode(){
        System.out.println(decode(decodedStr));
    }

    @Test
    public static void testIf(){
        System.out.println(testDecode(decodedStr));
    }
}
