package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService productCategoryService;

    @ApiOperation("Thêm danh mục sản phẩm")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:productCategory:create')")
    public CommonResult create(@Validated @RequestBody PmsProductCategoryParam productCategoryParam,
                               BindingResult result) {
        int count = productCategoryService.create(productCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:productCategory:update')")
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody PmsProductCategoryParam productCategoryParam,
                               BindingResult result) {
        int count = productCategoryService.update(id, productCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
