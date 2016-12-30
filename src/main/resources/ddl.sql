DROP SCHEMA IF EXISTS sal_data;
CREATE SCHEMA IF NOT EXISTS sal_data;
USE sal_data;

CREATE TABLE IF NOT EXISTS data_sources (
	data_source VARCHAR(128) NOT NULL,
	env VARCHAR(8) NOT NULL,
	first_load DATETIME NOT NULL DEFAULT NOW(),
	last_load DATETIME NOT NULL,
	PRIMARY KEY (data_source, env),
	INDEX USING BTREE (data_source, env)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS data_source_data_flow_tracker (
	data_source VARCHAR(128) NOT NULL,
	env VARCHAR(8) NOT NULL,
	last_load DATETIME DEFAULT NOW(),
	load_date DATE NOT NULL,
	event_count MEDIUMINT NOT NUll,
	PRIMARY KEY (data_source, env),
	INDEX USING BTREE (data_source, env)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS data_source_daily_events (
	data_source VARCHAR(128) NOT NULL,
	env VARCHAR(8) NOT NULL,
	event_type VARCHAR(8) NOT NULL,
	time_frame DATE NOT NULL,
	last_load DATETIME NOT NULL,
	event_count MEDIUMINT NOT NUll,
	PRIMARY KEY (data_source, env, event_type, time_frame),
	INDEX USING BTREE (data_source, env, event_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS file_details (
	file_name VARCHAR(512) NOT NULL,
	data_source VARCHAR(128) NOT NULL,
	catalog_tag VARCHAR(512) NOT NULL,
	parent_catalog_tag VARCHAR(512),
	file_size_kb MEDIUMINT DEFAULT 0,
	total_count MEDIUMINT DEFAULT 0,
	duplicate_count MEDIUMINT DEFAULT 0,
	error_count MEDIUMINT DEFAULT 0,
	unsupported_event_count MEDIUMINT DEFAULT 0,
	uploaded DATETIME DEFAULT NOW(),
	last_checked DATETIME,
	check_attempts INT DEFAULT 0,
	accepted TINYINT DEFAULT 0,
	raw_file TINYINT DEFAULT 0,
	PRIMARY KEY (catalog_tag),
	INDEX USING BTREE (data_source, catalog_tag, uploaded, last_checked, accepted)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;