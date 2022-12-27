import React from "react";
import { useForm } from "react-hook-form";
import styled from "styled-components";
import Header from "../../components/Header";
import SignupSideInfo from "../../components/SignupSideInfo";

export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  min-height: calc(100vh - 50px);
  background-color: #f1f2f3;
`;

export const SideContainer = styled.span`
  display: none;
  margin-right: 48px;
  @media (min-width: 817px) {
    display: block;
  }
`;

export const SignupBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const MobileTitle = styled.h1`
  margin-bottom: 24px;
  font-size: 19.8px;
  line-height: 25px;
  text-align: center;
  @media (min-width: 817px) {
    display: none;
  }
`;

export const SignupSocial = styled.div`
  display: flex;
  flex-direction: column;
  margin: 74px 0 16px 0;
`;

export const GoogleBtn = styled.button`
  width: 300px;
  padding: 10px;
  margin: 4px 0px;
  background-color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 5px;
  border: 1px solid hsl(210, 8%, 85%);
`;

export const BtnText = styled.span`
  margin-left: 5px;
`;

export const GithubBtn = styled(GoogleBtn)`
  background-color: #2f3338;
  color: white;
`;

export const FacebookBtn = styled(GithubBtn)`
  background-color: #365499;
`;

export const SignupBtn = styled(GithubBtn)`
  color: white;
  background-color: #1495fd;
  width: 252px;
`;

export const SingupFormBox = styled.form`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 300px;
  padding: 24px;
  background-color: white;
  border-radius: 7px;
  box-shadow: rgb(0 0 0 / 5%) 0px 10px 24px, rgb(0 0 0 / 5%) 0px 20px 48px,
    rgb(0 0 0 / 10%) 0px 1px 4px;
  margin-bottom: 24px;
  position: relative;
`;

export const InputBox = styled.div`
  margin: 6px 0;
`;

export const InputText = styled.label`
  padding: 0 2px;
  font-weight: bold;
`;

export const EmailInput = styled.input`
  width: 252px;
  margin-top: 5px;
  padding: 0.6em 0.7em;
  border-radius: 3px;
  border: 1px solid hsl(210, 8%, 75%);
  position: relative;
  border-color: ${(props) => (props.error ? "#de4f54" : "")};
  /* box-shadow: ${(props) =>
    props.error ? "0 0 0 4px #f7e1e1, 0 0 0 4px #f7e1e1" : ""}; */
  &:focus {
    outline: none;
    border-color: ${(props) => (props.error ? "#de4f54" : "#6bbbf7")};
    border-width: 1px;
    box-shadow: ${(props) =>
      props.error
        ? "0 0 0 4px #f7e1e1, 0 0 0 4px #f7e1e1"
        : "0 0 0 4px #cce9fe, 0 0 0 4px #cce9fe"};
  }
`;

export const PwInput = styled(EmailInput)``;

export const ErrorIcon = styled.div`
  position: absolute;
  right: 3%;
  top: 32.5%;
  pointer-events: none;
`;

export const ErrorBox = styled.div`
  position: relative;
`;

export const PwLink = styled.a`
  font-size: 12px;
  color: hsl(206, 100%, 40%);
  &:visited {
    color: #0e7bce;
  }
  &:hover {
    color: #379fef;
  }
`;

export const SignupLink = styled(PwLink)`
  font-size: 13px;
`;

export const LoginBox = styled.div`
  padding: 16px;
  text-align: center;
  font-size: 13px;
`;

export const LoginBox1 = styled.div`
  margin-top: 12px;
`;

export const ErrorText = styled.p`
  color: red;
  margin-top: 5px;
  padding: 2px;
  font-size: 12px;
`;

export const InputButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 35px;
  border-radius: 3px;
  border: 0px;
  padding: 2px 9px;
  margin-top: 30px;
  font-size: 0.85rem;
  color: white;
  background-color: #379fef;
  transition: all 0.4s ease 0s;
  cursor: pointer;
  &:hover {
    background-color: #0074cc;
  }
`;

export const Desc = styled.small`
  display: inline-block;
  margin-top: 25px;
  font-size: 11px;
  color: #6a737c;
  span {
    color: #0074cc;
  }
`;

export const SignUp = styled.p`
  color: rgb(35, 38, 41);
  display: flex;
  gap: 10px;
  font-size: 13px;
  a {
    color: #0e7bce;
    &:visited {
      color: #0e7bce;
    }
    &:hover {
      color: #379fef;
    }
  }
  margin-top: 50px;
`;

export const SignUp2 = styled.div`
  font-size: 12px;
  margin-top: 32px;
  a {
    color: #0e7bce;
    &:visited {
      color: #0e7bce;
    }
    &:hover {
      color: #379fef;
    }
  }
`;

const TestBox = styled.div`
  margin: 6px 0;
  padding: 8px 0px 2px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: hsl(210, 8%, 95%);
  border-color: hsl(210, 8%, 90%);
  border-radius: 3px;
  border-width: 1px;
`;

const RecaptchaBox = styled.div`
  width: 164px;
  height: 144px;
`;

const AdBox = styled.div`
  display: flex;
  margin: 6px 0;
`;

const CheckBox = styled.input`
  margin-right: 4px;
  vertical-align: middle;
  border-radius: 3px;
  background-position: center center;
  background-repeat: no-repeat;
  background-size: contain;
  width: 1em;
  height: 1em;
  border: 1px solid hsl(210, 8%, 75%);
  outline: 0;
  background-color: white;
`;

const AdInfo = styled.label`
  line-height: 1rem;
  cursor: pointer;
  font-weight: 400;
  font-size: 12px;
  padding: 0 2px;
  color: hsl(210, 8%, 5%);
`;

const QuestionBox = styled.div`
  margin-left: 4px;
  margin-top: 2px;
`;

const QuestionMark = styled.a``;

export default function Signup() {
  const EMAIL_REGEX =
    /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/;
  const PASSWORD_REGEX = /(?=.*\d)(?=.*[a-z]).{8,}/;

  const {
    register,
    handleSubmit,
    formState: { isSubmitting, errors },
  } = useForm();

  const emailRegister = register("email", {
    required: { value: true, message: "Email cannot be empty." },
    pattern: {
      value: EMAIL_REGEX,
      message: "The email is not a valid email address.",
    },
  });
  const passwordRegister = register("password", {
    required: { value: true, message: "Password cannot be empty." },
    pattern: {
      value: PASSWORD_REGEX,
      message: "The password is not a valid password address.",
    },
  });
  const nicknameRegister = register("nickname", {
    // required: { value: true, message: "닉네임을 입력해주세요." },
  });

  const onSubmit = (data) => {
    // console.log(data);
  };
  return (
    <>
      <Header />
      <Container>
        <SideContainer>
          <SignupSideInfo />
        </SideContainer>
        <SignupBox>
          <MobileTitle>
            Create your Stack Overflow account. It’s free and only takes a
            minute.
          </MobileTitle>
          <SignupSocial>
            <GoogleBtn>
              <svg
                aria-hidden="true"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path
                  d="M16.51 8H8.98v3h4.3c-.18 1-.74 1.48-1.6 2.04v2.01h2.6a7.8 7.8 0 0 0 2.38-5.88c0-.57-.05-.66-.15-1.18Z"
                  fill="#4285F4"
                ></path>
                <path
                  d="M8.98 17c2.16 0 3.97-.72 5.3-1.94l-2.6-2a4.8 4.8 0 0 1-7.18-2.54H1.83v2.07A8 8 0 0 0 8.98 17Z"
                  fill="#34A853"
                ></path>
                <path
                  d="M4.5 10.52a4.8 4.8 0 0 1 0-3.04V5.41H1.83a8 8 0 0 0 0 7.18l2.67-2.07Z"
                  fill="#FBBC05"
                ></path>
                <path
                  d="M8.98 4.18c1.17 0 2.23.4 3.06 1.2l2.3-2.3A8 8 0 0 0 1.83 5.4L4.5 7.49a4.77 4.77 0 0 1 4.48-3.3Z"
                  fill="#EA4335"
                ></path>
              </svg>
              <BtnText>Log in with Google</BtnText>
            </GoogleBtn>
            <GithubBtn>
              <svg
                aria-hidden="true"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path
                  d="M9 1a8 8 0 0 0-2.53 15.59c.4.07.55-.17.55-.38l-.01-1.49c-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82a7.42 7.42 0 0 1 4 0c1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48l-.01 2.2c0 .21.15.46.55.38A8.01 8.01 0 0 0 9 1Z"
                  fill="#fff"
                ></path>
              </svg>
              <BtnText>Log in with GitHub</BtnText>
            </GithubBtn>
            <FacebookBtn>
              <svg
                aria-hidden="true"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path
                  d="M3 1a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2H3Zm6.55 16v-6.2H7.46V8.4h2.09V6.61c0-2.07 1.26-3.2 3.1-3.2.88 0 1.64.07 1.87.1v2.16h-1.29c-1 0-1.19.48-1.19 1.18V8.4h2.39l-.31 2.42h-2.08V17h-2.5Z"
                  fill="#fff"
                ></path>
              </svg>
              <BtnText>Log in with Facebook</BtnText>
            </FacebookBtn>
          </SignupSocial>
          <SingupFormBox onSubmit={handleSubmit(onSubmit)}>
            <InputBox>
              <InputText htmlFor="nickname">Display name</InputText>
              <ErrorBox>
                <EmailInput
                  type="text"
                  error={errors.nickname?.message === undefined ? "" : "error"}
                  {...nicknameRegister}
                />
              </ErrorBox>
              {/* <ErrorText>{errors.nickname?.message}</ErrorText> */}
            </InputBox>
            <InputBox>
              <InputText htmlFor="email">Email</InputText>
              <ErrorBox>
                <EmailInput
                  type="text"
                  error={errors.email?.message === undefined ? "" : "error"}
                  {...emailRegister}
                />
                {errors.email?.message === undefined ? null : (
                  <ErrorIcon>
                    <svg
                      aria-hidden="true"
                      width="18"
                      height="18"
                      viewBox="0 0 18 18"
                    >
                      <path
                        d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"
                        fill="red"
                      ></path>
                    </svg>
                  </ErrorIcon>
                )}
              </ErrorBox>
              <ErrorText>{errors.email?.message}</ErrorText>
            </InputBox>
            <InputBox>
              <InputText htmlFor="password">Password</InputText>
              <ErrorBox>
                <PwInput
                  type="password"
                  error={errors.password?.message === undefined ? "" : "error"}
                  {...passwordRegister}
                />
                {errors.password?.message === undefined ? null : (
                  <ErrorIcon>
                    <svg
                      aria-hidden="true"
                      width="18"
                      height="18"
                      viewBox="0 0 18 18"
                    >
                      <path
                        d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"
                        fill="red"
                      ></path>
                    </svg>
                  </ErrorIcon>
                )}
              </ErrorBox>
              <ErrorText>{errors.password?.message}</ErrorText>
            </InputBox>
            <TestBox>
              <RecaptchaBox>
                <iframe
                  title="reCAPTCHA"
                  src="https://www.google.com/recaptcha/api2/anchor?ar=2&amp;k=6Lfmm70ZAAAAADvPzM6OhZ8Adi40-78E-aYfc1ZS&amp;co=aHR0cHM6Ly9zdGFja292ZXJmbG93LmNvbTo0NDM.&amp;hl=en&amp;v=5qcenVbrhOy8zihcc2aHOWD4&amp;size=compact&amp;cb=3unij7lmwk0y"
                  width="164"
                  height="144"
                  role="presentation"
                  name="a-9911dfsh95jz"
                  frameBorder="0"
                  scrolling="no"
                  sandbox="allow-forms allow-popups allow-same-origin allow-scripts allow-top-navigation allow-modals allow-popups-to-escape-sandbox"
                ></iframe>
              </RecaptchaBox>
            </TestBox>
            <AdBox>
              <CheckBox type="checkbox" />
              <AdInfo>
                Opt-in to receive occasional product updates, user research
                invitations, company announcements, and digests.
              </AdInfo>
              <QuestionBox>
                <QuestionMark>
                  <svg
                    aria-hidden="true"
                    width="14"
                    height="14"
                    viewBox="0 0 14 14"
                  >
                    <path
                      d="M7 1C3.74 1 1 3.77 1 7c0 3.26 2.77 6 6 6 3.27 0 6-2.73 6-6s-2.73-6-6-6Zm1.06 9.06c-.02.63-.48 1.02-1.1 1-.57-.02-1.03-.43-1.01-1.06.02-.63.5-1.04 1.08-1.02.6.02 1.05.45 1.03 1.08Zm.73-3.07-.47.3c-.2.15-.36.36-.44.6a3.6 3.6 0 0 0-.08.65c0 .04-.03.14-.16.14h-1.4c-.14 0-.16-.09-.16-.13-.01-.5.11-.99.36-1.42A4.6 4.6 0 0 1 7.7 6.07c.15-.1.21-.21.3-.33.18-.2.28-.47.28-.74.01-.67-.53-1.14-1.18-1.14-.9 0-1.18.7-1.18 1.46H4.2c0-1.17.31-1.92.98-2.36a3.5 3.5 0 0 1 1.83-.44c.88 0 1.58.16 2.2.62.58.42.88 1.02.88 1.82 0 .5-.17.9-.43 1.24-.15.2-.44.47-.86.79h-.01Z"
                      fill="rgb(106, 115, 124)"
                    ></path>
                  </svg>
                </QuestionMark>
              </QuestionBox>
            </AdBox>
            <SignupBtn>Sign up</SignupBtn>
            <SignUp2>
              By clicking “Sign up”, you agree to our{" "}
              <a
                href="https://stackoverflow.com/legal/terms-of-service/public"
                name="tos"
                target="_blank"
                rel="noreferrer"
              >
                terms of service
              </a>
              ,{" "}
              <a
                href="https://stackoverflow.com/legal/privacy-policy"
                name="privacy"
                target="_blank"
                rel="noreferrer"
              >
                privacy policy
              </a>{" "}
              and{" "}
              <a
                href="https://stackoverflow.com/legal/cookie-policy"
                name="cookie"
                target="_blank"
                rel="noreferrer"
              >
                cookie policy
              </a>
              <input type="hidden" name="legalLinksShown" value="1" />
            </SignUp2>
          </SingupFormBox>

          <LoginBox>
            Already have an account?{" "}
            <SignupLink href="/login">Log in</SignupLink>
            <LoginBox1>
              Are you an employer?
              <SignupLink
                href="https://careers.stackoverflow.com/employer/login"
                name="talent"
              >
                {" "}
                Sign up on Talent
                <svg
                  aria-hidden="true"
                  width="14"
                  height="14"
                  viewBox="0 0 14 14"
                >
                  <path
                    d="M5 1H3a2 2 0 0 0-2 2v8c0 1.1.9 2 2 2h8a2 2 0 0 0 2-2V9h-2v2H3V3h2V1Zm2 0h6v6h-2V4.5L6.5 9 5 7.5 9.5 3H7V1Z"
                    fill="#2e70b3"
                  ></path>
                </svg>
              </SignupLink>
            </LoginBox1>
          </LoginBox>
        </SignupBox>
      </Container>
    </>
  );
}
