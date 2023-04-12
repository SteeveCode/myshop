package com.myshop.admin.setting;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.Setting;

public interface SettingRepository extends JpaRepository<Setting, String> {

}
