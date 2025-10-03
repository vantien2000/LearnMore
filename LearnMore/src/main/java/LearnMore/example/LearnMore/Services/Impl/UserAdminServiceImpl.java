package LearnMore.example.LearnMore.Services.Impl;

import LearnMore.example.LearnMore.IRepository.IUserAdminRepository;
import LearnMore.example.LearnMore.Services.IUserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
public class UserAdminServiceImpl implements IUserAdminService {
    @Autowired
    private IUserAdminRepository userAdminRepository;

}
