CREATE TABLE Audit (
    id SERIAL PRIMARY KEY,
    method VARCHAR (255) NOT NULL,
    account_id BIGINT NOT NULL,
    start_balance DECIMAL NOT NULL,
    amount DECIMAL NOT NULL,
    end_balance DECIMAL NOT NULL,
    user_id VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

