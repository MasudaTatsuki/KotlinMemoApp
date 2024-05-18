DROP DATABASE IF EXISTS memoappdb;
CREATE DATABASE memoappdb;
USE memoappdb;

--　テーブルの初期化
DROP TABLE IF EXISTS memos;
DROP TABLE IF EXISTS users;

-- テーブルの作成
CREATE TABLE memos (
  memo_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

-- データのインサート
INSERT INTO memos (
  user_id,
  title,
  content,
  created_at,
  updated_at
) VALUES (
  1,
  'test',
  'It is test.',
  CURRENT_TIMESTAMP,
  CURRENT_TIMESTAMP
);

INSERT INTO memos (
  user_id,
  title,
  content,
  created_at,
  updated_at
) VALUES (
  1,
  'test2',
  'is It test ?',
  CURRENT_TIMESTAMP,
  CURRENT_TIMESTAMP
);

INSERT INTO memos (
  user_id,
  title,
  content,
  created_at,
  updated_at
) VALUES (
  1,
  'test3',
  'test, test and test.',
  CURRENT_TIMESTAMP,
  CURRENT_TIMESTAMP
);

INSERT INTO memos (
  user_id,
  title,
  content,
  created_at,
  updated_at
) VALUES (
  2,
  'test',
  'test, test and test.',
  CURRENT_TIMESTAMP,
  CURRENT_TIMESTAMP
);

INSERT INTO users (
  user_name,
  email,
  password_hash,
  created_at,
  updated_at
) VALUES (
  'tatsuki masuda',
  'test@gmail.com',
  '12345',
  CURRENT_TIMESTAMP,
  CURRENT_TIMESTAMP
);

INSERT INTO users (
  user_name,
  email,
  password_hash,
  created_at,
  updated_at
) VALUES (
  'toro yamada',
  'test2@gmail.com',
  '123456789',
  CURRENT_TIMESTAMP,
  CURRENT_TIMESTAMP
);