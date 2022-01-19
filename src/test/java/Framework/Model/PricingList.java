package Framework.Model;

import java.util.Objects;

public class PricingList {
    private String instances;
    private String series;
    private String machineType;
    private String gpu;
    private String gpuType;
    private String gpuNumber;
    private String localSSD;
    private String dataCenter;
    private String committedUsage;

    public PricingList(String instances, String series, String machineType, String gpu, String gpuType, String gpuNumber, String localSSD, String dataCenter, String committedUsage) {
        this.instances = instances;
        this.series = series;
        this.machineType = machineType;
        this.gpu = gpu;
        this.gpuType = gpuType;
        this.gpuNumber = gpuNumber;
        this.localSSD = localSSD;
        this.dataCenter = dataCenter;
        this.committedUsage = committedUsage;
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
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String haveGPU() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getGpuNumber() {
        return gpuNumber;
    }

    public void setGpuNumber(String gpuNumber) {
        this.gpuNumber = gpuNumber;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingList that = (PricingList) o;
        return gpu == that.gpu && Objects.equals(instances, that.instances) && Objects.equals(series, that.series) && Objects.equals(machineType, that.machineType) && Objects.equals(gpuType, that.gpuType) && Objects.equals(gpuNumber, that.gpuNumber) && Objects.equals(localSSD, that.localSSD) && Objects.equals(dataCenter, that.dataCenter) && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, series, machineType, gpu, gpuType, gpuNumber, localSSD, dataCenter, committedUsage);
    }

    @Override
    public String toString() {
        return "PricingList{" +
                "instances=" + instances +
                ", series='" + series + '\'' +
                ", MachineType='" + machineType + '\'' +
                ", GPU=" + gpu +
                ", GpuType='" + gpuType + '\'' +
                ", GpuNumber=" + gpuNumber +
                ", LocalSSD='" + localSSD + '\'' +
                ", DataCenter='" + dataCenter + '\'' +
                ", CommittedUsage=" + committedUsage +
                '}';
    }
}
