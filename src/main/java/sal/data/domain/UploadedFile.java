package sal.data.domain;

import java.io.Serializable;
import java.util.Date;

public class UploadedFile implements Serializable {
	private String fileName;
	private String dataSource;
	private String catalogTag;
	private String parentCatalogTag;
	private long fileSizeKb;
	private long totalCount;
	private long dupCount;
	private long errorCount;
	private long unsupportedEventTypeCount;
	private Date uploaded;
	private Date lastChecked;
	private int checkAttempts;
	private boolean accepted;
	private boolean rawFile;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getCatalogTag() {
		return catalogTag;
	}
	public void setCatalogTag(String catalogTag) {
		this.catalogTag = catalogTag;
	}
	public String getParentCatalogTag() {
		return parentCatalogTag;
	}
	public void setParentCatalogTag(String parentCatalogTag) {
		this.parentCatalogTag = parentCatalogTag;
	}
	public long getFileSizeKb() {
		return fileSizeKb;
	}
	public void setFileSizeKb(long fileSizeKb) {
		this.fileSizeKb = fileSizeKb;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getDupCount() {
		return dupCount;
	}
	public void setDupCount(long dupCount) {
		this.dupCount = dupCount;
	}
	public long getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(long errorCount) {
		this.errorCount = errorCount;
	}
	public long getUnsupportedEventTypeCount() {
		return unsupportedEventTypeCount;
	}
	public void setUnsupportedEventTypeCount(long unsupportedEventTypeCount) {
		this.unsupportedEventTypeCount = unsupportedEventTypeCount;
	}
	public Date getUploaded() {
		return uploaded;
	}
	public void setUploaded(Date uploaded) {
		this.uploaded = uploaded;
	}
	public Date getLastChecked() {
		return lastChecked;
	}
	public void setLastChecked(Date lastChecked) {
		this.lastChecked = lastChecked;
	}
	public int getCheckAttempts() {
		return checkAttempts;
	}
	public void setCheckAttempts(int checkAttempts) {
		this.checkAttempts = checkAttempts;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public boolean isRawFile() {
		return rawFile;
	}
	public void setRawFile(boolean rawFile) {
		this.rawFile = rawFile;
	}
	
}
