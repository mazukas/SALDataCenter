package sal.data.models.files;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "file_details")
public class SalDataFile implements Serializable {
	
	@Id
	@Column(name="catalog_tag")
	private String catalogTag;
	
	@NotNull
	@Column(name="file_name")
	private String fileName;
	
	@NotNull
	@Column(name="data_source")
	private String dataSource;
	
	@Column(name="parent_catalog_tag")
	private String parentCatalogTag;
	
	@Column(name="file_size_kb")
	private long fileSizeKb;
	
	@Column(name="total_count")
	private long totalCount;
	
	@Column(name="duplicate_count")
	private long dupCount;
	
	@Column(name="error_count")
	private long errorCount;
	
	@Column(name="unsupported_event_count")
	private long unsupportedEventTypeCount;
	
	@Column(name="uploaded")
	private Date uploaded;
	
	@Column(name="last_checked")
	private Date lastChecked;
	
	@Column(name="check_attempts")
	private int checkAttempts;
	
	@Column(name="accepted")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean accepted;
	
	@Column(name="raw_file")
	@Type(type = "org.hibernate.type.NumericBooleanType")
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
