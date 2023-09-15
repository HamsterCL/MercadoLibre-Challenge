FROM gradle:8.3.0-jdk20-jammy AS TEST

COPY --chown=gradle:gradle ./test-automation-challenge /app/test

WORKDIR /app/test

ENTRYPOINT ["gradle"]

CMD ["build", "--info"]