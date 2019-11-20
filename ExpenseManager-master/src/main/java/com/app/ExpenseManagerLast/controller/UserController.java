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
import com.app.ExpenseManagerLast.dto.UserDetails;
import com.app.ExpenseManagerLast.model.ExpenseModel;
import com.app.ExpenseManagerLast.model.CategoryModel;
import com.app.ExpenseManagerLast.model.UserModel;
import com.app.ExpenseManagerLast.service.ICategoryService;
import com.app.ExpenseManagerLast.service.IExpenseService;
import com.app.ExpenseManagerLast.service.IUserService;

import io.swagger.models.auth.In;

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
	public ResponseEntity<?> registerUser(@RequestBody UserDetails user) {
		try {
			if (user.getPassword().toString().equals(user.getConfirmPassword().toString())) {
				System.out.println("pass"+user.getPassword());
				System.out.println("confirm password"+user.getConfirmPassword());
				return new ResponseEntity<Integer>(userService.registerUserJPA(user), HttpStatus.OK);
			}
			return new ResponseEntity<String>("password dosen't match", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Registeration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/loginUser")
	public ResponseEntity<?> loginUser(@RequestBody UserModel user, HttpSession hs) {
		try {
			UserModel validUser = userService.loginUser(user.getEmailId(), user.getPassword());
			hs.setAttribute("validUser", validUser);
			return new ResponseEntity<UserModel>(validUser, HttpStatus.OK);
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
			return new ResponseEntity<List<CategoryModel>>(categoryService.getAllCategories(), HttpStatus.OK);
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
	
	@PostMapping(path = "/resgisterWithJPA")
	public Integer reisterUserWithRepo(@RequestBody UserDetails user) {
		
		return userService.registerUserJPA(user);
	}
}

