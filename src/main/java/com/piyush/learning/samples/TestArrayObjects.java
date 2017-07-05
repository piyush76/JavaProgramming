package com.piyush.learning.samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Piyush_G on 11/28/2016.
 */
public class TestArrayObjects {

    TestArrayObjects(){

    }

    public ACPartSerialData[] buildPartSerialData(final List<FdlCustProdCompMfgSerial> fdlCustProdCompMfgSerialList, final ACPartData base) {

        ACPartSerialData acPartSerialData = null;
        List<ACPartSerialData> list = Collections.emptyList();

        if (null != fdlCustProdCompMfgSerialList && !fdlCustProdCompMfgSerialList.isEmpty()) {
            for (FdlCustProdCompMfgSerial fdlCustProdCompMfgSerial : fdlCustProdCompMfgSerialList) {
                if (null != fdlCustProdCompMfgSerial) {
                    acPartSerialData.setPartData(base);
                    list.add(acPartSerialData);

                }
            }

        }
        return (ACPartSerialData[]) list.toArray();
    }


    public static class FdlCustProdCompMfgSerial {

        public FdlCustProdCompMfgSerial(String serial) {
            this.compMfgSerial = serial;

        }


        public String getCompMfgSerial() {
            return compMfgSerial;
        }

        public void setCompMfgSerial(String compMfgSerial) {
            this.compMfgSerial = compMfgSerial;
        }

        private String compMfgSerial;


    }

    public static class ACPartData {


    }


    public class ACPartSerialData {

        public ACPartData getPartData() {
            return partData;
        }

        public void setPartData(ACPartData partData) {
            this.partData = partData;
        }

        private ACPartData partData = null;

    }


}
