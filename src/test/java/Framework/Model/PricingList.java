package Framework.Model;

import java.util.Objects;

public class PricingList {
    private String instances;
    private String series;
    private String MachineType;
    private String GPU;
    private String GpuType;
    private String GpuNumber;
    private String LocalSSD;
    private String DataCenter;
    private String CommittedUsage;

    public PricingList(String instances, String series, String machineType, String GPU, String gpuType, String gpuNumber, String localSSD, String dataCenter, String committedUsage) {
        this.instances = instances;
        this.series = series;
        MachineType = machineType;
        this.GPU = GPU;
        GpuType = gpuType;
        GpuNumber = gpuNumber;
        LocalSSD = localSSD;
        DataCenter = dataCenter;
        CommittedUsage = committedUsage;
    }

    public String getInstances() {
        return instances;
    }

    public void setInstances(String instances) {
        this.instances = instances;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return MachineType;
    }

    public void setMachineType(String machineType) {
        MachineType = machineType;
    }

    public String haveGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getGpuType() {
        return GpuType;
    }

    public void setGpuType(String gpuType) {
        GpuType = gpuType;
    }

    public String getGpuNumber() {
        return GpuNumber;
    }

    public void setGpuNumber(String gpuNumber) {
        GpuNumber = gpuNumber;
    }

    public String getLocalSSD() {
        return LocalSSD;
    }

    public void setLocalSSD(String localSSD) {
        LocalSSD = localSSD;
    }

    public String getDataCenter() {
        return DataCenter;
    }

    public void setDataCenter(String dataCenter) {
        DataCenter = dataCenter;
    }

    public String getCommittedUsage() {
        return CommittedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        CommittedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingList that = (PricingList) o;
        return GPU == that.GPU && Objects.equals(instances, that.instances) && Objects.equals(series, that.series) && Objects.equals(MachineType, that.MachineType) && Objects.equals(GpuType, that.GpuType) && Objects.equals(GpuNumber, that.GpuNumber) && Objects.equals(LocalSSD, that.LocalSSD) && Objects.equals(DataCenter, that.DataCenter) && Objects.equals(CommittedUsage, that.CommittedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, series, MachineType, GPU, GpuType, GpuNumber, LocalSSD, DataCenter, CommittedUsage);
    }

    @Override
    public String toString() {
        return "PricingList{" +
                "instances=" + instances +
                ", series='" + series + '\'' +
                ", MachineType='" + MachineType + '\'' +
                ", GPU=" + GPU +
                ", GpuType='" + GpuType + '\'' +
                ", GpuNumber=" + GpuNumber +
                ", LocalSSD='" + LocalSSD + '\'' +
                ", DataCenter='" + DataCenter + '\'' +
                ", CommittedUsage=" + CommittedUsage +
                '}';
    }
}
