package RollingRolling.RollingMindBackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({PastReleaseDateException.class})
    protected ResponseEntity handlePastReleaseDateException(PastReleaseDateException ex){
        return ResponseEntity
                .status(ErrorCode.PAST_DATE_SELECTED.getStatus().value())
                .body(new ErrorDTO(ErrorCode.PAST_DATE_SELECTED));
    }

    @ExceptionHandler({ParticipantNotFoundException.class})
    protected ResponseEntity handleParticipantNotFoundException(ParticipantNotFoundException ex){
        return ResponseEntity
                .status(ErrorCode.PARTICIPANT_NOT_FOUND.getStatus().value())
                .body(new ErrorDTO(ErrorCode.PARTICIPANT_NOT_FOUND));
    }

    @ExceptionHandler({RoomNotFoundException.class})
    protected ResponseEntity handleRoomNotFoundException(RoomNotFoundException ex){
        return ResponseEntity
                .status(ErrorCode.ROOM_NOT_FOUND.getStatus().value())
                .body(new ErrorDTO(ErrorCode.ROOM_NOT_FOUND));
    }

    @ExceptionHandler({TemplateNotFoundException.class})
    protected ResponseEntity handleTemplateNotFoundException(TemplateNotFoundException ex){
        return ResponseEntity
                .status(ErrorCode.TEMPLATE_NOT_FOUND.getStatus().value())
                .body(new ErrorDTO(ErrorCode.TEMPLATE_NOT_FOUND));
    }

    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity handleBadRequestNotFoundException(BadRequestException ex){
        return ResponseEntity
                .status(ErrorCode.BAD_REQUEST.getStatus().value())
                .body(new ErrorDTO(ErrorCode.BAD_REQUEST));
    }
}
