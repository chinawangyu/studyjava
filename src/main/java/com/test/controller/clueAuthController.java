package com.test.controller;

import com.test.controller.viewobject.ClueAuthVO;
import com.test.error.BusinessException;
import com.test.error.EmBusinessError;
import com.test.response.CommonReturnType;
import com.test.service.ClueAuthService;
import com.test.service.model.ClueAuthLogModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/auth")
public class clueAuthController extends BaseController{

    @Autowired
    private ClueAuthService clueAuthService;

    @RequestMapping("/get")
    public CommonReturnType getInfo(@RequestParam(name = "id") Integer id) throws BusinessException {
        ClueAuthLogModel clueAuthLogModel = clueAuthService.getInfo(id);

        //将model转换为可供ui使用的viewobject
        ClueAuthVO clueAuthVO = convertFromModel(clueAuthLogModel);
        if (clueAuthVO == null) {
            throw new BusinessException(EmBusinessError.DATA_NOT_EXIST);
        }

        return CommonReturnType.create(clueAuthVO);
    }

    /**
     * 转换
     * @param clueAuthLogModel
     * @return
     */
    private ClueAuthVO convertFromModel(ClueAuthLogModel clueAuthLogModel) {
        if (clueAuthLogModel == null) {
            return null;
        }

        ClueAuthVO clueAuthVO = new ClueAuthVO();
        BeanUtils.copyProperties(clueAuthLogModel, clueAuthVO);
        return clueAuthVO;
    }

}
