package com.sideprojects.joshmiller.buttons;

/**
 * Created by josh on 7/22/15.
 */
public class GlobalLevels {
    public static Level[] levels= {
        new Level(new int[][]{{ButtonColors.dGreen,ButtonColors.lGreen},{ButtonColors.lGreen,ButtonColors.dGreen}},null),
        new Level(new int[][]{{ButtonColors.lGreen,ButtonColors.lBlue},{ButtonColors.dGreen,ButtonColors.lGreen}},new PartnerList[]{new PartnerList(1,new int[]{2})}),
        new Level(new int[][]{{ButtonColors.lGreen, ButtonColors.dGreen,ButtonColors.dBlue}, {ButtonColors.lGreen,ButtonColors.lBlue, ButtonColors.dBlue}, {ButtonColors.lBlue,ButtonColors.dGreen,ButtonColors.lGreen}}, new PartnerList[]{new PartnerList(2,new int[]{1}),new PartnerList(4,new int[]{3}),new PartnerList(5,new int[]{8}),new PartnerList(6,new int[]{7})}),
        new Level(new int[][]{{ButtonColors.lBlue,ButtonColors.lGreen,ButtonColors.dBlue},{ButtonColors.dGreen,ButtonColors.lGreen,ButtonColors.lGreen},{ButtonColors.lGreen,ButtonColors.dGreen,ButtonColors.lBlue}},new PartnerList[]{new PartnerList(0,new int[]{3}), new PartnerList(2, new int[]{1}), new PartnerList(8,new int[]{7})}),
        new Level(new int[][]{{ButtonColors.lBlue,ButtonColors.dGreen,ButtonColors.lGreen},{ButtonColors.lGreen,ButtonColors.dBlue,ButtonColors.lOrange},{ButtonColors.dGreen,ButtonColors.lGreen,ButtonColors.dBlue}},new PartnerList[]{new PartnerList(0,new int[]{1}),new PartnerList(4,new int[]{6}),new PartnerList(5,new int[]{2,7}), new PartnerList(8,new int[]{5})}),
        new Level(new int[][]{{ButtonColors.dBlue,ButtonColors.lGreen,ButtonColors.dOrange,ButtonColors.dGreen},{ButtonColors.dOrange,ButtonColors.lBlue,ButtonColors.lGreen,ButtonColors.lOrange},{ButtonColors.dGreen,ButtonColors.dGreen,ButtonColors.lBlue,ButtonColors.dOrange},{ButtonColors.lBlue,ButtonColors.dBlue,ButtonColors.lOrange,ButtonColors.dGreen}}, new PartnerList[]{new PartnerList(0,new int[]{5}),new PartnerList(2,new int[]{1,7}), new PartnerList(4, new int[]{0,8}),new PartnerList(5,new int[]{9}), new PartnerList(7,new int[]{3,11}), new PartnerList(10, new int[]{14}), new PartnerList(11,new int[]{10,15}), new PartnerList(12, new int[]{13}), new PartnerList(13,new int[]{10}), new PartnerList(14, new int[]{9,15}) })
    };
}
