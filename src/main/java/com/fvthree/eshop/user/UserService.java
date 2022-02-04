package com.fvthree.eshop.user;

public interface UserService {

    UserDTO get(final Long id);

    User findByUserByUsername(final String username);

    User create(final UserDTO userDTO);

    void update(final Long id, final UserDTO userDTO);

    void delete(final Long id);
}
