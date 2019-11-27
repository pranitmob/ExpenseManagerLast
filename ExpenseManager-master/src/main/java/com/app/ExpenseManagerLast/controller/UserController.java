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
import com.app.ExpenseManagerLast.dto.ExpenseDetails;
import com.app.ExpenseManagerLast.dto.UserDetails;
import com.app.ExpenseManagerLast.service.ICategoryService;
import com.app.ExpenseManagerLast.service.IExpenseService;
import com.app.ExpenseManagerLast.service.IUserService;

/**
 * Controller class which maps all the incoming requests of user
 */
/**
 * @author Pranit
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LogManager.getLogger(UserController.class);
	
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
				log.info("User Registeration");
				return new ResponseEntity<Integer>(userService.registerUserJPA(user), HttpStatus.OK);
			}
			return new ResponseEntity<String>("password dosen't match", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Registeration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/loginUser")
	public ResponseEntity<?> loginUser(@RequestBody UserDetails user, HttpSession hs) {
		try {
			UserDetails validUser = userService.loginUser(user.getEmail(), user.getPassword());
			hs.setAttribute("validUser", validUser);
			log.info("user Login");
			return new ResponseEntity<UserDetails>(validUser, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserNotFoundException("user not found");
		}
	}

	@PostMapping("/addExpense")
	public ResponseEntity<String> addExpense(@RequestBody ExpenseDetails expense) {
		try {
			log.info("Add expense from controller");
			return new ResponseEntity<String>(expenseService.addExpense(expense), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Expense not added please check", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**get list of all categories
	 * @return List<Object> if successful or String in case of error
 	 */
	@GetMapping("/getCategories")
	public ResponseEntity<?> getAllCategories() {
		try {
			log.info("Get all categories");
			return new ResponseEntity<List<Object>>(categoryService.getAllCategories(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Categories fecth failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**get list of monthly expenses
	 * @return List of object array if successful or String in case of error	
	 */
	@GetMapping("/getMonthlyExpenses")
	public ResponseEntity<?> getListOfExpenses() {
		try {
			   log.info("et Monthly expenses");  
			return new ResponseEntity<List<Object[]>>(expenseService.getListOfExpenses(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Cannot fetch Monthly expenses", HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	
	/**
	 * 
	 * @return Sum of expenses 
	 */
	@GetMapping("/getSumOfExpenses")
	public ResponseEntity<?> getSumOfAllExpenses() {
		try {
			log.info("");
			return new ResponseEntity<Double>(expenseService.sumOfallExpense(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>("Cannot fetch Monthly expenses", HttpStatus.SERVICE_UNAVAILABLE);
		}

	}
	
}

