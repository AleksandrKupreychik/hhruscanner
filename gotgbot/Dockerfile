FROM golang:1.23.2-alpine as builder
WORKDIR /opt/app
ENV CGO_ENABLED=0 \
    GOOS=linux
COPY . .
RUN go mod download
RUN go mod tidy
RUN go build -o service


FROM alpine
RUN apk --no-cache add ca-certificates
WORKDIR /opt/app
COPY --from=builder /opt/app/service .
COPY --from=builder /opt/app/.env .
EXPOSE 8082
CMD ["./service"]

