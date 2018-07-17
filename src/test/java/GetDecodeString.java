import org.testng.annotations.Test;

import static gdprCrypt.PurposeData.*;
import static gdprCrypt.Encoder.consent;

public class GetDecodeString {

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
        не отвечаем рекламой в кампаниях CPI/CPC поскольку для оптимизации нам нужны все три consent.
        если Information storage and access = false - то по CPM мы отвечаем рекламой,
        но не записываем персональные данные. Impression, click записываем*/
    @Test
    public void withpurp13only(){
        consent(purp13only);
    }


    /*
    не используем таргетинг по Audience - всегда успешно проходим проверку на Exclude=Black List,
     и всегда фейлим Include = White List
не передаем IDFA для получения списка тегов для прогонки по Optimization Model, считаем что тегов нет.
в любом случае проверяем IDFA и IP на попадание в глобальные Black List
проверяем IDFA на срабатывание Impression и Click Cap, также на Install Cap (сейчас это называется Conversion Cap).
не используем Personal Data данного пользователя в дальнейшем:
вариант 1: очищаем personal data fields в Bid Request перед записью в логи - RTBC-1603, или
вариант 2: отмечаем в логах особым образом что Personal Data данного пользователя не должна использоваться
в Audience Engine (возможно через RTBC-1653).
Как следствие пункта 4.б для CPI/CPC может сработать “дефолтный” сценарий типа как для нового пользователя.
 Но этот пользователь с таким consent будет всегда как “новый”, поэтому был добавлен 1.б.
    если Information storage and access = true оставляем personal data fields в Bid Request без изменений, записываем в логи
           не отвечаем рекламой в кампаниях CPI/CPC поскольку для оптимизации нам нужны все три consent.
       если Ad selection, delivery, reporting = false
       не показываем рекламу, отвечаем 204 No Bid
       а если Personalisation = true
   можем использовать таргетинг по Audience, и
   передаем IDFA для получения списка тегов для прогонки по Optimization Model
   Если CPM то без personalization мы можем ответить рекламой.
   Например если есть только black list или нет аудитории в кампании и на экаунте вообще
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
     */
    @Test
    public void withpurp23only(){
        consent(purp23only);
    }

    // 204
    @Test
    public void withnoAllowedPurposes(){
        consent(noAllowedPurposes);
    }

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
    public void withemptyPurposes(){
        consent(emptyPurposes);
    }
}
