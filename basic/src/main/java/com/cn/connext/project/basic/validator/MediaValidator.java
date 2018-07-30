package com.cn.connext.project.basic.validator;

import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.basic.repository.MediaRepository;
import com.cn.connext.project.framework.Validator;
import com.cn.connext.project.framework.exception.ServiceBadRequestException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;


/**
 * 媒体信息 - 实体验证定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Component
public class MediaValidator {

    /**
     * “媒体信息”数据存储接口
     */
    @Resource
    private MediaRepository mediaRepository;

    /**
     * 验证所要创建的“媒体信息”对象实例，是否符合数据约定。
     *
     * @param media “媒体信息”对象实例
     */
    public void createValidate(Media media) {
        if (mediaRepository.exists(media.getId()))
            throw new ServiceBadRequestException("basic_media_error_create_idExist");

        entityValidate(media);
    }

    /**
     * 验证所要修改的“媒体信息”对象实例，是否符合数据约定。
     *
     * @param media “媒体信息”对象实例
     */
    public void modifyValidate(Media media) {
        if (!mediaRepository.exists(media.getId()))
            throw new ServiceBadRequestException("basic_media_error_modify_idNotExist");

        entityValidate(media);
    }

    /**
     * 验证所要删除的“媒体信息”，是否符合数据约定。
     *
     * @param id “媒体信息”对象的唯一标识
     */
    public void deleteValidate(String id) {
        if (!mediaRepository.exists(id))
            throw new ServiceBadRequestException("basic_media_error_delete_idNotExist");
    }

    /**
     * 验证所传入的“媒体信息”对象实例，是否符合数据约定。
     *
     * @param media “媒体信息”对象实例
     */
    public void entityValidate(Media media) {

        // 检测更新时间是否为空
        if (Validator.isEmpty(media.getUpdateTime()))
            throw new ServiceBadRequestException("basic_media_error_valid_updateTimeIsNull");

        // 检测唯一编号是否为UUID格式
        if (Validator.isNotUUID(media.getId()))
            throw new ServiceBadRequestException("basic_media_error_valid_idNotUUID");

        // 检测媒体类型编号是否为UUID格式
        if (Validator.isNotUUID(media.getMediaTypeId()))
            throw new ServiceBadRequestException("basic_media_error_valid_mediaTypeIdNotUUID");

        // 检测名称长度
        if (Validator.isOutLimit(media.getName(), 64))
            throw new ServiceBadRequestException("basic_media_error_valid_nameOutLimit");

        // 检测代码长度
        if (Validator.isOutLimit(media.getCode(), 32))
            throw new ServiceBadRequestException("basic_media_error_valid_codeOutLimit");

        // 检测备注长度
        if (Validator.isOutLimit(media.getRemark(), 256))
            throw new ServiceBadRequestException("basic_media_error_valid_remarkOutLimit");

    }

}

