package com.macro.mall.controller;


import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.elasticsearch.model.EsProduct;
import com.macro.mall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.elasticsearch.index.query.Operator.AND;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * 搜索商品管理Controller
 * Created by macro on 2018/6/19.
 */
@Controller
@Api(tags = "EsProductController", description = "Tìm kiếm quản lý sản phẩm")
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @ApiOperation(value = "Nhập tất cả các mục cơ sở dữ liệu vào ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "Xóa các mục dựa trên id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "Xóa các mục hàng loạt dựa trên id")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "Tạo sản phẩm dựa trên id")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return CommonResult.success(esProduct);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "Tìm kiếm đơn giản")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "Tìm kiếm theo tên")
    @RequestMapping(value = "/search/name", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> searchByName(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(matchQuery("name",keyword).operator(AND))
//                .build();
//        com.github.pagehelper.Page<EsProduct> articles = (com.github.pagehelper.Page<EsProduct>) elasticsearchTemplate
//                .queryForList(searchQuery, EsProduct.class);
//
//
//        return CommonResult.success(CommonPage.restPage(articles));


        Page<EsProduct> esProductPage = esProductService.searchByName(keyword, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(esProductPage));
    }


}
