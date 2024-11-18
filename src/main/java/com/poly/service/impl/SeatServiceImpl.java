package com.poly.service.impl;

import com.poly.model.Account;
import com.poly.model.Room;
import com.poly.model.Seat;
import com.poly.model.Showtime;
import com.poly.repository.RoomRepository;
import com.poly.repository.SeatClassRepository;
import com.poly.repository.SeatRepository;
import com.poly.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired 
    private RoomRepository roomRepository; 
    @Autowired 
    private SeatClassRepository seatClassRepository;

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> getSeatById(Integer id) {
        return seatRepository.findById(id);
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeatById(Integer id) {
        seatRepository.deleteById(id);
    }

	@Override
	public List<Seat> findByRoomId(int roomId) {
		return seatRepository.findByRoomId(roomId);
	}

	@Override
	public <S extends Seat> S save(S entity) {
		return seatRepository.save(entity);
	}

	@Override
	public <S extends Seat> List<S> saveAll(Iterable<S> entities) {
		return seatRepository.saveAll(entities);
	}

	@Override
	public <S extends Seat> Optional<S> findOne(Example<S> example) {
		return seatRepository.findOne(example);
	}

	@Override
	public List<Seat> findAll(Sort sort) {
		return seatRepository.findAll(sort);
	}

	@Override
	public void flush() {
		seatRepository.flush();
	}

	@Override
	public Page<Seat> findAll(Pageable pageable) {
		return seatRepository.findAll(pageable);
	}

	@Override
	public <S extends Seat> S saveAndFlush(S entity) {
		return seatRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Seat> List<S> saveAllAndFlush(Iterable<S> entities) {
		return seatRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Seat> findAll() {
		return seatRepository.findAll();
	}

	@Override
	public List<Seat> findAllById(Iterable<Integer> ids) {
		return seatRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Seat> entities) {
		seatRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Seat> Page<S> findAll(Example<S> example, Pageable pageable) {
		return seatRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Seat> findById(Integer id) {
		return seatRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Seat> entities) {
		seatRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return seatRepository.existsById(id);
	}

	@Override
	public <S extends Seat> long count(Example<S> example) {
		return seatRepository.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		seatRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Seat> boolean exists(Example<S> example) {
		return seatRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		seatRepository.deleteAllInBatch();
	}

	@Override
	public Seat getOne(Integer id) {
		return seatRepository.getOne(id);
	}

	@Override
	public <S extends Seat, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return seatRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return seatRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		seatRepository.deleteById(id);
	}

	@Override
	public Seat getById(Integer id) {
		return seatRepository.getById(id);
	}

	@Override
	public void delete(Seat entity) {
		seatRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		seatRepository.deleteAllById(ids);
	}

	@Override
	public Seat getReferenceById(Integer id) {
		return seatRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Seat> entities) {
		seatRepository.deleteAll(entities);
	}

	@Override
	public <S extends Seat> List<S> findAll(Example<S> example) {
		return seatRepository.findAll(example);
	}

	@Override
	public <S extends Seat> List<S> findAll(Example<S> example, Sort sort) {
		return seatRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		seatRepository.deleteAll();
	}
	@Override
	public List<Seat> getSeatsByRoomId(int roomId) {
	    return seatRepository.findByRoomId(roomId);
	}

	@Override
	public Optional<Seat> findByRoomIdAndRowNumberAndSeatNumber(int roomId, String rowNumber, int seatNumber) {
		return seatRepository.findByRoomIdAndRowNumberAndSeatNumber(roomId, rowNumber, seatNumber);
	}

    // Kiểm tra ghế đã được chọn hay chưa
    public boolean isSeatBooked(Integer showtimeId, Integer roomId, Account account) {
        return seatRepository.existsByShowtimeIdAndRoomIdAndAccountId(showtimeId, roomId, account.getId());
    }

    public void bookSeat(Integer showtimeId, Integer roomId, Account account) {
        // Tìm ghế với các tham số showtime, room và account
        Seat seat = seatRepository.findByShowtimeIdAndRoomIdAndAccountId(showtimeId, roomId, account.getId());

       
            // Nếu ghế đã được chọn, chỉ cần thay đổi trạng thái của ghế
            seat.setStatus(true); // Đảm bảo ghế vẫn được chọn
            seatRepository.save(seat);
       
    }


    public void unbookSeat(Integer showtimeId, Integer roomId, Account account) {
        // Tìm ghế đã được chọn
        Seat seat = seatRepository.findByShowtimeIdAndRoomIdAndAccountId(showtimeId, roomId, account.getId());

        if (seat != null) {
            // Thay đổi trạng thái ghế về chưa chọn (hoặc xóa ghế nếu cần)
            seat.setStatus(false);
            seatRepository.save(seat); // Cập nhật trạng thái ghế
        } else {
            // Nếu không tìm thấy ghế
            throw new IllegalStateException("Ghế chưa được chọn");
        }
    }

}
