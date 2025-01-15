let studentName = "";
let questions = [
  {
    question: "What is the main purpose of the 'static' keyword in Java?",
    options: ["To create a constant variable", "To create a class-level variable", "To create an instance variable", "To create a final variable"],
    correctAnswer: "To create a class-level variable"
  },
  {
    question: "Which of the following is not a valid data type in Java?",
    options: ["int", "float", "double", "charp"],
    correctAnswer: "charp"
  },

 
    {
      question: "What does JVM stand for in Java?",
      options: ["Java Virtual Machine", "Java Visual Machine", "Java Virtual Method", "Java Visual Method"],
      correctAnswer: "Java Virtual Machine"
    },
    {
      question: "Which keyword is used for inheritance in Java?",
      options: ["super", "this", "extend", "inherits"],
      correctAnswer: "extend"
    },
    {
      question: "What is the purpose of the 'finally' block in Java?",
      options: ["To handle exceptions", "To execute code whether an exception is thrown or not", "To define a method", "To declare variables"],
      correctAnswer: "To execute code whether an exception is thrown or not"
    },
    {
      question: "Which of the following is a marker interface in Java?",
      options: ["Runnable", "Serializable", "Comparable", "Cloneable"],
      correctAnswer: "Serializable"
    },
    {
      question: "What is the default value of a local variable in Java?",
      options: ["0", "null", "undefined", "Depends on the data type"],
      correctAnswer: "undefined"
    },
    {
      question: "What is the difference between '==' and '.equals()' in Java?",
      options: ["They are interchangeable", "'.equals()' is used for primitive types, '==' for objects", "'.equals()' is used for objects, '==' for primitive types", "There is no difference"],
      correctAnswer: "'.equals()' is used for objects, '==' for primitive types"
    },
    {
      question: "Which Java keyword is used to prevent a method from being overridden in a subclass?",
      options: ["protected", "static", "final", "abstract"],
      correctAnswer: "final"
    },
    {
      question: "What is the use of the 'break' statement in Java?",
      options: ["To end the execution of a loop or switch statement", "To skip the current iteration of a loop", "To exit a method", "To terminate the program"],
      correctAnswer: "To end the execution of a loop or switch statement"
    },
    {
      question: "Which collection class is synchronized in Java?",
      options: ["ArrayList", "LinkedList", "HashSet", "Vector"],
      correctAnswer: "Vector"
    },
    {
      question: "What is the purpose of the 'static' keyword in Java?",
      options: ["To create a constant variable", "To create a class-level variable", "To create an instance variable", "To create a final variable"],
      correctAnswer: "To create a class-level variable"
    },
    {
      question: "In Java, what is the purpose of the 'super' keyword?",
      options: ["To call the superclass constructor", "To access the superclass fields and methods", "To create an instance of the superclass", "To define a superclass"],
      correctAnswer: "To access the superclass fields and methods"
    },
    {
      question: "Which method is called when an object is garbage collected in Java?",
      options: ["finalize()", "dispose()", "clean()", "collect()"],
      correctAnswer: "finalize()"
    },
    // Add 9 more questions here...
  ];
  


let currentQuestion = 0;
let score = 0;

function startQuiz() {
  const nameInput = document.getElementById("studentName");
  studentName = nameInput.value.trim();

  if (studentName === "") {
    alert("Please enter your name to start the quiz.");
  } else {
    document.getElementById("start-page").style.display = "none";
    loadQuestion();
  }
}

function shuffleQuestions() {
  for (let i = questions.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [questions[i], questions[j]] = [questions[j], questions[i]];
  }
}

function loadQuestion() {
    const quizElement = document.getElementById("quiz");
    const optionsElement = document.getElementById("options");
  
    shuffleQuestions();
  
    // Display question number along with the question text
    const questionNumber = currentQuestion + 1;
    quizElement.textContent = `${questionNumber}. ${questions[currentQuestion].question}`;
  
    optionsElement.innerHTML = "";
  
    for (const option of questions[currentQuestion].options) {
      const button = document.createElement("button");
      button.textContent = option;
      button.onclick = () => checkAnswer(option);
      optionsElement.appendChild(button);
    }
  }
  

function checkAnswer(selectedOption) {
  if (selectedOption === questions[currentQuestion].correctAnswer) {
    score++;
  }

  currentQuestion++;

  if (currentQuestion < questions.length) {
    loadQuestion();
  } else {
    showResult();
  }
}

// ... (previous code)

const passThreshold = 10; // Set the required score threshold

function showResult() {
  const resultElement = document.getElementById("result");
  const certificateElement = document.getElementById("certificate");
  const retestElement = document.getElementById("retest");
  const studentNameDisplay = document.getElementById("studentNameDisplay");
  const certificateName = document.getElementById("certificateName");

  resultElement.textContent = `You scored ${score} out of ${questions.length}.`;
  resultElement.style.display = "block";

  studentNameDisplay.textContent = studentName;

  if (score >= passThreshold) {
    certificateName.textContent = studentName;
    certificateElement.style.display = "block";
    retestElement.style.display = "none";
  } else {
    certificateElement.style.display = "none";
    retestElement.style.display = "block";
  }
}

// ... (remaining code)


function restartQuiz() {
  document.getElementById("start-page").style.display = "block";
  document.getElementById("quiz").textContent = "";
  document.getElementById("options").innerHTML = "";
  document.getElementById("result").textContent = "";
  document.getElementById("certificate").style.display = "none";

  currentQuestion = 0;
  score = 0;
}



function submitScore(score) {
    fetch("/submitScore", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ score: score })
    })
    .then(response => response.json())
    .then(data => {
        console.log("Score submitted successfully", data);
    })
    .catch(error => {
        console.error("Error submitting score", error);
    });
}


// ... (previous code)
// ... (previous code)



// ... (remaining code)


  // ... (remaining code)
  