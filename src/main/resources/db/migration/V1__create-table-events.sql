CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    start_at TIMESTAMP NOT NULL,
    end_at TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    maximum_capacity INT,
    organizer VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL
)

