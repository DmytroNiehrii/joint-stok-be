package com.jointstock.jointstokbe.converter;

import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.extra.CommunityCard;
import org.springframework.core.convert.converter.Converter;

final class CommunityToCommunityCard implements Converter<Community, CommunityCard> {
    public CommunityCard convert(Community source) {
        return new CommunityCard(source);
    }
}
