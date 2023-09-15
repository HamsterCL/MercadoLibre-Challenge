# EXECUTE BFF

FROM golang:1.20 AS BFF

# Set destination for COPY
WORKDIR /app

# Download Go modules
COPY /automation-challenge/go.mod /automation-challenge/go.sum ./
RUN go mod download

COPY ./automation-challenge/cmd/api ./cmd/api
COPY ./automation-challenge/internal ./internal

# Build
RUN CGO_ENABLED=0 GOOS=linux go build -o /automation-challenge cmd/api/main.go


EXPOSE 8080

# Run
CMD ["/automation-challenge"]



#EXECUTE TEST

FROM gradle:8.3.0-jdk20-jammy AS TEST

COPY --chown=gradle:gradle ./test-automation-challenge /app/test

WORKDIR /app/test

ENTRYPOINT ["gradle"]

CMD ["build", "--info"]