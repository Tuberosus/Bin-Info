package ru.me.bin_info.util

enum class HttpStatusCode(code: Int) {
    DUMMY(code = 0),
    NOT_CONNECTED(code = -1),
    OK(code = 200),
    BAD_REQUEST(code = 400),
    NOT_FOUND(code = 404),
    HIT_LIMIT(code = 429),
    INTERNAL_SERVER_ERROR(code = 500),
}