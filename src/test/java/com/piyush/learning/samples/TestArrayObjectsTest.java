package com.piyush.learning.samples;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piyush_G on 11/28/2016.
 */
public class TestArrayObjectsTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();


    }

    @Test
    public void buildPartSerialData() {

        TestArrayObjects.FdlCustProdCompMfgSerial fdlCustProdCompMfgSerial = new TestArrayObjects.FdlCustProdCompMfgSerial("sdsddfds");

        TestArrayObjects.ACPartData base = new TestArrayObjects.ACPartData();

        List<TestArrayObjects.FdlCustProdCompMfgSerial> fdlCustProdCompMfgSerialList = new ArrayList<TestArrayObjects.FdlCustProdCompMfgSerial>();
        fdlCustProdCompMfgSerialList.add(fdlCustProdCompMfgSerial);

        TestArrayObjects test = new TestArrayObjects();
        TestArrayObjects.ACPartSerialData[] acPartSerialDatas = test.buildPartSerialData(fdlCustProdCompMfgSerialList, base);

    }


}