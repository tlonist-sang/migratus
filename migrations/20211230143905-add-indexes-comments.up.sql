CREATE INDEX tag_idx on comments(tag);
--;;
alter table comments add column is_hot tinyint(1) default 0;
--;;
set global innodb_adaptive_hash_index = 1;