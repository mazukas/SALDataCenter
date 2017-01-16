DELETE FROM data_sources;
INSERT INTO data_sources VALUES ('mock-data-source-1', 'DEV', DATE_SUB(NOW(), INTERVAL 30 DAY), NOW());
INSERT INTO data_sources VALUES ('mock-data-source-1', 'TEST', DATE_SUB(NOW(), INTERVAL 19 DAY), NOW());
INSERT INTO data_sources VALUES ('mock-data-source-2', 'DEV', DATE_SUB(NOW(), INTERVAL 35 DAY), NOW());
INSERT INTO data_sources VALUES ('mock-data-source-2', 'TEST', DATE_SUB(NOW(), INTERVAL 5 DAY), NOW());
INSERT INTO data_sources VALUES ('mock-data-source-3', 'TEST', DATE_SUB(NOW(), INTERVAL 15 DAY), NOW());
INSERT INTO data_sources VALUES ('mock-data-source-3', 'DEV', DATE_SUB(NOW(), INTERVAL 25 DAY), NOW());

INSERT INTO data_sources VALUES ('mock-data-source-3', 'PROD', NOW(), NOW());



DELETE FROM file_details;
INSERT INTO file_details VALUES ('file-1', 'mock-data-source-1', 'mock-catalog-tag-abc123', null, 10000, 100, 0, 0, 0, DATE_SUB(NOW(), INTERVAL 30 DAY), null, 1, 1, 1);
INSERT INTO file_details VALUES ('file-2', 'mock-data-source-1', 'mock-catalog-tag-abr423', null, 50000, 500, 0, 3, 0, DATE_SUB(NOW(), INTERVAL 15 DAY), null, 1, 0, 1);
INSERT INTO file_details VALUES ('file-3', 'mock-data-source-1', 'mock-catalog-tag-dbr413', null, 75000, 750, 0, 0, 0, DATE_SUB(NOW(), INTERVAL 17 DAY), null, 1, 0, 0);

INSERT INTO file_details VALUES ('file-4', 'mock-data-source-2', 'mock-catalog-tag-dbg443', null, 15000, 150, 1, 1, 1, DATE_SUB(NOW(), INTERVAL 3 DAY), null, 1, 1, 1);
INSERT INTO file_details VALUES ('file-5', 'mock-data-source-2', 'mock-catalog-tag-dbi493', null, 75000, 750, 0, 0, 0, DATE_SUB(NOW(), INTERVAL 21 DAY), null, 1, 1, 0);
INSERT INTO file_details VALUES ('file-6', 'mock-data-source-2', 'mock-catalog-tag-dee413', null, 100, 1, 0, 0, 0, DATE_SUB(NOW(), INTERVAL 8 DAY), null, 1, 1, 0);
INSERT INTO file_details VALUES ('file-7', 'mock-data-source-2', 'mock-catalog-tag-dwq443', null, 50000, 500, 0, 10, 0, DATE_SUB(NOW(), INTERVAL 5 DAY), null, 1, 1, 0);

INSERT INTO file_details VALUES ('file-8', 'mock-data-source-3', 'mock-catalog-tag-qws243', null, 100000, 1000, 0, 0, 0, DATE_SUB(NOW(), INTERVAL 23 DAY), null, 1, 1, 0);
INSERT INTO file_details VALUES ('file-9', 'mock-data-source-3', 'mock-catalog-tag-qwd263', null, 25000, 250, 0, 1, 0, DATE_SUB(NOW(), INTERVAL 14 DAY), null, 1, 1, 0);
INSERT INTO file_details VALUES ('file-10', 'mock-data-source-3', 'mock-catalog-tag-jpd163', null, 75000, 750, 3, 0, 1, DATE_SUB(NOW(), INTERVAL 10 DAY), null, 1, 1, 0);

INSERT INTO file_details VALUES ('file-11', 'mock-data-source-3', 'mock-catalog-tag-tpe131', null, 100000, 100, 0, 0, 0, NOW(), null, 1, 1, 0);

DELETE FROM data_source_daily_events;
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', NOW(), NOW(), 15000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', NOW(), NOW(), 10000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', NOW(), NOW(), 5000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', NOW(), NOW(), 150);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', NOW(), NOW(), 3000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', NOW(), NOW(), 750);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'ACCOUNTS', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 3000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 20000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 5000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 60000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 150);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 3000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', (NOW() - INTERVAL 1 DAY), (NOW() - INTERVAL 1 DAY), 750);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'ACCOUNTS', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 1500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 2500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 7500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 5000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 300);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 4000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 1200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'PROD', 'ITEMS', (NOW() - INTERVAL 2 DAY), (NOW() - INTERVAL 2 DAY), 6500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SESSIONS', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 4500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 4200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 10000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 12000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 350);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 4200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', (NOW() - INTERVAL 3 DAY), (NOW() - INTERVAL 3 DAY), 4000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SESSIONS', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 5000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 5500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 450);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 350);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 2300);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', (NOW() - INTERVAL 4 DAY), (NOW() - INTERVAL 4 DAY), 5650);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'ITEMS', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 3500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 4500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 8000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 6000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 4550);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 3400);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', (NOW() - INTERVAL 5 DAY), (NOW() - INTERVAL 5 DAY), 100);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'ITEMS', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 1200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'SEARCHES', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 120);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'PING', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 230);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'DEV', 'WEB', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 7500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'SEARCHES', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 4200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'PING', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 5550);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-1', 'TEST', 'ITEMS', (NOW() - INTERVAL 6 DAY), (NOW() - INTERVAL 6 DAY), 1000);


INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'DEV', 'ACCOUNTS', NOW(), NOW(), 150);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'DEV', 'PING', NOW(), NOW(), 8000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'DEV', 'SESSIONS', NOW(), NOW(), 800);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'DEV', 'WEB', NOW(), NOW(), 2000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'TEST', 'WEB', NOW(), NOW(), 1500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'TEST', 'PING', NOW(), NOW(), 2300);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-2', 'TEST', 'SEARCHES', NOW(), NOW(), 450);

INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'DEV', 'SEARCHES', NOW(), NOW(), 75);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'DEV', 'PING', NOW(), NOW(), 3000);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'DEV', 'WEB', NOW(), NOW(), 3400);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'TEST', 'ACCOUNTS', NOW(), NOW(), 300);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'TEST', 'WEB', NOW(), NOW(), 4500);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'TEST', 'ITEMS', NOW(), NOW(), 550);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'TEST', 'SESSIONS', NOW(), NOW(), 1200);
INSERT INTO data_source_daily_events VALUES ('mock-data-source-3', 'TEST', 'PING', NOW(), NOW(), 3100);



DELETE FROM alerts;
INSERT INTO alerts (title, recorded, status) VALUES ('mock-data-source-4 data has not been seen in 8 days', NOW(), 'MISSING');
INSERT INTO alerts (title, recorded, status) VALUES ('mock-data-source-5 is a new data source that just showed up', NOW(), 'ADDED');
INSERT INTO alerts (title, recorded, status) VALUES ('mock-data-source-1 is ready for review', NOW(), 'REVIEW');

commit;