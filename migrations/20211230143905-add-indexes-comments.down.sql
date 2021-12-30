DELETE INDEX tag_idx;
--;
alter table comments drop column is_hot;
--;
set global innodb_adaptive_hash_index = 0;