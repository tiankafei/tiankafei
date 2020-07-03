package org.tiankafei.user.login.service.impl;

import org.springframework.stereotype.Service;
import org.tiankafei.user.login.service.VerificationService;
import org.tiankafei.web.common.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class VerificationServiceServiceImpl implements VerificationService {

    @Override
    public String verificationCode(HttpServletRequest request, HttpServletResponse response) throws VerificationException {
        return null;
    }

}
