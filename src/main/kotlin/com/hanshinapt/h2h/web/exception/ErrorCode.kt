package com.hanshinapt.h2h.web.exception

import org.springframework.http.HttpStatus

/**
 * @author sangbeenmoon
 */
enum class ErrorCode(val httpStatus: HttpStatus, val code: Int, val message: String) {


}
