package com.app.ExpenseManagerLast.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ExpenseManagerLast.Exception.UserNotFoundException;
import com.app.ExpenseManagerLast.model.ExpenseModel;
import com.app.ExpenseManagerLast.model.categoryModel;
import com.app.ExpenseManagerLast.model.userModel;
import com.app.ExpenseManagerLast.service.ICategoryService;
import com.app.ExpenseManagerLast.service.IExpenseService;
import com.app.ExpenseManagerLast.service.IUserService;

/**
 * @author Pranit
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")

public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IExpenseService expenseService;

	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody userModel user) {
		try {
			if (user.getPassword().equals(user.getConfirmPassword())) {
				logger.info("login successfull");
				return new ResponseEntity<String>(userService.resgiserUser(user), HttpStatus.OK);
			}
			logger.error("login successfull");
			return new ResponseEntity<String>("password dosen't match", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<String>("Registeration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/loginUser")
	public ResponseEntity<?> loginUser(@RequestBody userModel user, HttpSession hs) {
		try {
			userModel validUser = userService.loginUser(user.getEmailId(), user.getPassword());
			hs.setAttribute("validUser", validUser);
			return new ResponseEntity<userModel>(validUser, HttpStatus.OK);
		} catch (Exception e) {
			throw new UserNotFoundException("user not found");
		}
	}

	@PostMapping("/addExpense")
	public ResponseEntity<String> addExpense(@RequestBody ExpenseModel expense) {
		try {
			return new ResponseEntity<String>(expenseService.addExpense(expense), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Expense not added please check", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getCategories")
	public ResponseEntity<?> getAllCategories() {
		try {
			return new ResponseEntity<List<categoryModel>>(categoryService.getAllCategories(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Categories fecth failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getMonthlyExpenses")
	public ResponseEntity<?> getListOfExpenses() {
		try {
			return new ResponseEntity<List<Object>>(expenseService.getListOfExpenses(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Cannot fetch Monthly expenses", HttpStatus.SERVICE_UNAVAILABLE);
		}

	}
}

