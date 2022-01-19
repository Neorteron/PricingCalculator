package Framework.Service;

import Framework.Model.PricingList;

public class ListCreator {
    private static final String instances = "testdata.list.instances";
    private static final String series = "testdata.list.series";
    private static final String machineType = "testdata.list.MachineType";
    private static final String gpu = "testdata.list.GPU";
    private static final String gpuType = "testdata.list.GpuType";
    private static final String gpuNumber = "testdata.list.GpuNumber";
    private static final String localSSD = "testdata.list.LocalSSD";
    private static final String dataCenter = "testdata.list.DataCenter";
    private static final String committedUsage = "testdata.list.CommittedUsage";

    public static PricingList withCredentialsFromProperty (){
        return new PricingList(TestDataReader.getTestData(instances),
                TestDataReader.getTestData(series),
                TestDataReader.getTestData(machineType),
                TestDataReader.getTestData(gpu),
                TestDataReader.getTestData(gpuType),
                TestDataReader.getTestData(gpuNumber),
                TestDataReader.getTestData(localSSD),
                TestDataReader.getTestData(dataCenter),
                TestDataReader.getTestData(committedUsage));
    }


}
