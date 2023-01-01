import React from "react";
import styled from "styled-components";

const Header = styled.header`
  display: flex;
  flex-direction: column;
  padding-bottom: 16px;
  font-size: 13px;
  color: #232639;
  line-height: 1.4;
  p {
    max-width: 590px;
    font-size: 15px;
    margin: 0 0 16px;
  }
`;

const Title = styled.h1`
  font-size: 26px;
  margin: 0 0 16px;
`;

const AllTags = styled.a`
  text-decoration: none;
  color: #0074cc;
  cursor: pointer;
  margin-bottom: 24px;
  &:hover {
    color: #0a95ff;
  }
`;

const FormBtnContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Form = styled.form`
  display: flex;
  width: 188px;
  height: 37px;
  max-width: 100%;
  align-items: center;
  position: relative;
  .search {
    position: absolute;
    left: 0px;
    opacity: 0.4;
    margin: 0 0.5rem;
  }
`;

const Input = styled.input`
  padding: 1rem 1rem 1rem 2rem;
  width: 100%;
  height: 2.3rem;
  border: 1px solid hsl(210deg 8% 75%);
  border-radius: 3px;
  &:focus {
    outline: none;
    border-color: hsl(206deg 90% 70%);
    box-shadow: 0px 0px 0px 5px #e1ecf4;
  }
  &::placeholder {
    color: rgb(190, 192, 195);
  }
`;

const FilterContainer = styled.div`
  vertical-align: baseline;
  border: 1px solid rgb(148, 156, 163);
  border-radius: 5px;
`;

const FilterBtn = styled.button`
  width: 80px;
  height: 35px;
  color: #6a737c;
  background-color: white;
  border: none;
  font-size: 12px;
  cursor: pointer;
  &.left-btn {
    border-top-left-radius: 5px 5px;
    border-bottom-left-radius: 5px 5px;
    border-right: 1px solid rgb(148, 156, 163);
  }
  &.right-btn {
    border-top-right-radius: 5px 5px;
    border-bottom-right-radius: 5px 5px;
  }
  &.sorted {
    background-color: #e3e6e8;
    color: #3b4045;
    pointer-events: none;
  }
  &:hover {
    background-color: rgb(247, 247, 247);
    color: #525960;
  }
`;

export default function UserHeader({
  setSort,
  sort,
  setOrder,
  setValue,
  value,
}) {
  const handleBtnClick = (e) => {
    setSort(e.target.innerText);
    if (e.target.innerText === "New users") {
      setOrder("asc");
    } else {
      setOrder("desc");
    }
  };

  const handleInputChange = (e) => {
    setValue(e.target.value);
  };

  const onSubmit = (e) => {
    e.preventDefault();
  };
  return (
    <Header>
      <Title>Users</Title>
      <FormBtnContainer>
        <Form onSubmit={onSubmit}>
          <svg className="search" width="18" height="18" viewBox="0 0 18 18">
            <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z" />
          </svg>
          <Input
            placeholder="Filter by user"
            type="text"
            value={value}
            onChange={handleInputChange}
          />
        </Form>
        <FilterContainer>
          <FilterBtn
            onClick={handleBtnClick}
            className={sort === "Reputation" ? "left-btn sorted" : "left-btn"}
          >
            Reputation
          </FilterBtn>
          <FilterBtn
            onClick={handleBtnClick}
            className={sort === "New users" ? "right-btn sorted" : "right-btn"}
          >
            New users
          </FilterBtn>
        </FilterContainer>
      </FormBtnContainer>
    </Header>
  );
}
