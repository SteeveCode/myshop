package com.myshop.admin.setting;

import com.myshop.common.entity.setting.SettingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.common.entity.setting.Setting;

import java.util.List;

public interface SettingRepository extends JpaRepository<Setting, String> {
    public List<Setting> findByCategory(SettingCategory category);

}
