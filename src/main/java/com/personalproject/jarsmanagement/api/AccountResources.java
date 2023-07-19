package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.AccountNoPasswordDTO;
import com.personalproject.jarsmanagement.service.DTO.AccountDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/account")
public class AccountResources {
    private final AccountService accountService;


    @GetMapping
    ResponseEntity<List<AccountDTO>> findAllAccount() {
        return ResponseEntity.ok(accountService.findAllAccount());
    }

    @PostMapping
    ResponseEntity<AccountNoPasswordDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }

    @PutMapping
    ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(accountService.updateAccount(accountDTO, token));
    }

//    @Value("${file.upload-dir}")
//    String FILE_DICRECTORY;
//
//    @PostMapping("/File")
//    ResponseEntity<Object> fileUpload(MultipartFile image) throws IOException {
//        File myFile = new File(FILE_DICRECTORY + image.getOriginalFilename());
//        myFile.createNewFile();
//        FileOutputStream fos = new FileOutputStream(myFile);
//        fos.write(image.getBytes());
//        fos.close();
//        return new ResponseEntity<Object>("The File Upload Successfully", HttpStatus.OK);
//    }
}
