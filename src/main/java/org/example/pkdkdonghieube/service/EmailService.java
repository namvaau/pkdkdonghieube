package org.example.pkdkdonghieube.service;
import org.example.pkdkdonghieube.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getEmail()); // Gửi cho khách hàng
        message.setSubject("Xác nhận đặt lịch khám bệnh");
        message.setText("Chào " + request.getName() + ",\n\n"
                + "Cảm ơn bạn đã đặt lịch hẹn với chúng tôi.\n"
                + "Ngày hẹn: " + request.getDate() + "\n"
                + "Số điện thoại: " + request.getPhone() + "\n\n"
                + "Bác Sĩ : " + request.getDoctor() + "\n\n"
                + "Chuyên Khoa: " + request.getSpeciality() + "\n\n"
                + "Chúng tôi sẽ liên hệ với bạn sớm nhất!\n"
                + "Trân trọng.");

        mailSender.send(message);
        SimpleMailMessage adminMessage = new SimpleMailMessage();
        adminMessage.setTo("hoainam.vaau@gmail.com");
        adminMessage.setSubject("Lịch hẹn mới từ khách hàng " + request.getName());
        adminMessage.setText("Khách hàng: " + request.getName() + "\n"
                + "Email: " + request.getEmail() + "\n"
                + "Ngày hẹn: " + request.getDate() + "\n"
                + "Số điện thoại: " + request.getPhone() + "\n"
                + "Bác sĩ: " + request.getDoctor() + "\n"
                + "Chuyên khoa: " + request.getSpeciality());
        mailSender.send(adminMessage);

    }
}
