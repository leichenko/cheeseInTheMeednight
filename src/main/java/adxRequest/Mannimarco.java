package adxRequest;

import com.google.openrtb.OpenRtb;
import com.google.openrtb.json.OpenRtbJsonFactory;
import com.google.protobuf.ByteString;

public class Mannimarco {
    private static OpenRtb.BidRequest request;


    public static void main(String[] args) {
        OpenRtbJsonFactory openrtbJson = OpenRtbJsonFactory.create();
// How to serialize
//        ByteString jsonReq = openrtbJson.newWriter().writeBidRequest(request);

    }
}
