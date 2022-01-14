package Framework.Service;

import Framework.Model.PricingList;

public class ListCreator {
    private static final String instances = "testdata.list.instances";
    private static final String series = "testdata.list.series";
    private static final String MachineType = "testdata.list.MachineType";
    private static final String GPU = "testdata.list.GPU";
    private static final String GpuType = "testdata.list.GpuType";
    private static final String GpuNumber = "testdata.list.GpuNumber";
    private static final String LocalSSD = "testdata.list.LocalSSD";
    private static final String DataCenter = "testdata.list.DataCenter";
    private static final String CommittedUsage = "testdata.list.CommittedUsage";

    public static PricingList withCredentialsFromProperty (){
        return new PricingList(TestDataReader.getTestData(instances),
                TestDataReader.getTestData(series),
                TestDataReader.getTestData(MachineType),
                TestDataReader.getTestData(GPU),
                TestDataReader.getTestData(GpuType),
                TestDataReader.getTestData(GpuNumber),
                TestDataReader.getTestData(LocalSSD),
                TestDataReader.getTestData(DataCenter),
                TestDataReader.getTestData(CommittedUsage));
    }


}
