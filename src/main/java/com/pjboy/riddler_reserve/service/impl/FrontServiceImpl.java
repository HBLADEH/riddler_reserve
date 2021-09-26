package com.pjboy.riddler_reserve.service.impl;

import com.pjboy.riddler_reserve.model.vo.InitVO;
import com.pjboy.riddler_reserve.service.FrontService;
import com.pjboy.riddler_reserve.service.RoomService;
import com.pjboy.riddler_reserve.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FrontServiceImpl implements FrontService {
  @Autowired
  private RoomService roomService;

  @Autowired
  private RoundService roundService;

  @Override
  public InitVO getInitData() {
    InitVO initVO = new InitVO();
    initVO.setRooms(roomService.ListRooms());
    initVO.setRounds(roundService.ListRounds());
    return initVO;
  }
}

//        } public String minWindow(String s, String t) {
//          Map<Character, Integer> need , window;
//          char[] tArr = t.toCharArray();
//          for (char c : tArr) need[c]++;
//          int left = 0, right = 0;
//          int valid = 0;
//          // 记住最小覆盖字串的起始索引及长度
//          int start = 0, len = Integer.MAX_VALUE;
//          while (right < s.len()) {
//            // c 是将移入窗口的字符
//            char c = s[right];
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//            if (need.count(c)) {
//              window[c]++;
//              if (window[c]==need[c])
//                valid++;
//            }
//
//            // 判断左侧窗口是否要收缩
//            while (vaild == need.size()) {
//              // 在这里更新最小覆盖字串
//              if (right - left < len) {
//                start = left;
//                len = right - left;
//      }
//      // d 是将移出窗口的字符
//      char d = s[left];
//      // 左移窗口
//      left++;
//      // 进行窗口内数据的一系列更新
//      if (need.count(d)) {
//        if (window[d]== need[d]) vaild--;
//        window[d]--;
//      }
//    }
//    return len == Integer.MAX_VALUE ? "" : s.substr(start,len);
//  }
//}
