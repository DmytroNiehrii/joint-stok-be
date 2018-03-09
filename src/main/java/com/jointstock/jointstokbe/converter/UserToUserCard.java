package com.jointstock.jointstokbe.converter;

import com.jointstock.jointstokbe.model.User;
import com.jointstock.jointstokbe.model.extra.UserCard;
import org.springframework.core.convert.converter.Converter;

final class UserToUserCard implements Converter<User, UserCard> {
    public UserCard convert(User source) {
        return new UserCard(source);
    }
}
