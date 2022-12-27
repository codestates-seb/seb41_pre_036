import { createBrowserRouter, RouterProvider } from "react-router-dom";
import NotFound from "./pages/NotFound";
import QuestionDetail from "./pages/Questions/QuestionDetail";
import QuestionsList from "./pages/Questions/QuestionsList";
import Login from "./pages/Register/Login";
import Signup from "./pages/Register/Signup";
import Logout from "./pages/Register/Logout";
import Tags from "./pages/Tags";
import Users from "./pages/Users";
import Mypage from "./pages/Mypage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <QuestionsList />,
    errorElement: <NotFound />,
    children: [],
  },
  {
    path: "/:questionId",
    element: <QuestionDetail />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/signup",
    element: <Signup />,
  },
  {
    path: "/logout",
    element: <Logout />,
  },
  {
    path: "/tags",
    element: <Tags />,
  },
  {
    path: "/users",
    element: <Users />,
  },
  {
    path: "/mypage",
    element: <Mypage />,
  },
]);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
