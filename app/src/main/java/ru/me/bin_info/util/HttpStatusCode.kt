package ru.me.bin_info.util

enum class HttpStatusCode {
    NOT_CONNECTED, // -1
    CLARIFY_REQUEST, // 0
    OK, // 200
    BAD_REQUEST, // 400
    NOT_FOUND, // 404
    HIT_LIMIT, // 429
    INTERNAL_SERVER_ERROR, // 500
}